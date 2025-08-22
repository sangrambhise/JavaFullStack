import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {IProduct} from '../iproduct'

@Component({
  selector: 'app-productedit',
  imports: [CommonModule, FormsModule],
  templateUrl: './productedit.component.html',
  styleUrl: './productedit.component.css'
})
export class ProducteditComponent implements OnInit {
  product: IProduct = { name: '', category: '', price: 0, qty:0};
  id: string | null = null;

  constructor(private route: ActivatedRoute, private service: ProductService, private router: Router) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.service.findProduct(this.id).subscribe(data => this.product = data);
    }
  }

  save() {
    this.service.updateProduct(this.product).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
