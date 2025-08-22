import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { CommonModule } from '@angular/common';
import { IProduct } from '../iproduct';
@Component({
  selector: 'app-productadd',
  imports: [CommonModule, FormsModule],
  templateUrl: './productadd.component.html',
  styleUrl: './productadd.component.css'
})
export class ProductaddComponent {
  // Ex1
  product: IProduct = { name: '', category: '', price: 0, qty:0 };

  constructor(private service: ProductService, private router: Router) {}

  add() {
    this.service.addProduct(this.product).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
