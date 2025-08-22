import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink} from '@angular/router';
import { IProduct } from '../iproduct';
import { ProductService } from '../product.service';
@Component({
  selector: 'app-productlist',
  imports: [CommonModule, RouterLink],
  templateUrl: './productlist.component.html',
  styleUrl: './productlist.component.css'
})
export class ProductlistComponent {
  // Ex1
 products: IProduct[] = [];

  constructor(private service: ProductService, private router: Router) {}

  ngOnInit() {
    this.service.getProducts().subscribe(data => this.products = data);
  }

  addProduct() {
    this.router.navigate(['/add']);
  }
}
