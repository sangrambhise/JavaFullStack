import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { OrderService } from '../../services/order.service';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-create',
  imports: [CommonModule, FormsModule, ReactiveFormsModule,],
  templateUrl: './order-create.component.html',
  styleUrl: './order-create.component.css'
})
export class OrderCreateComponent implements OnInit {

  orderForm: FormGroup;
  products: any[] = [];
  cartItems: any[] = [];
  successMessage: string = '';
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private orderService: OrderService,
    private productService: ProductService,
    private router: Router
  ) {
    this.orderForm = this.fb.group({
      productId: ['', Validators.required],
      quantity: [1, [Validators.required, Validators.min(1)]]
    });
  }

  ngOnInit(): void {
    this.loadProducts();
    this.loadCart();
  }

  loadProducts() {
    this.productService.getProducts().subscribe({
      next: (data: any) => this.products = data,
      error: () => this.errorMessage = 'Failed to load products'
    });
  }

  loadCart() {
    this.orderService.viewCart().subscribe({
      next: (data: any) => this.cartItems = data.items || [],
      error: () => this.errorMessage = 'Failed to load cart'
    });
  }

  addToCart() {
    if (this.orderForm.invalid) return;

    const { productId, quantity } = this.orderForm.value;
    this.orderService.addToCart(productId, quantity).subscribe({
      next: () => {
        this.successMessage = 'Product added to cart!';
        this.errorMessage = '';
        this.loadCart(); 
      },
      error: () => {
        this.errorMessage = 'Failed to add product to cart';
        this.successMessage = '';
      }
    });
  }

  updateCartItem(itemId: number, qty: number) {
    if (qty < 1) return;
    this.orderService.updateCartItem(itemId, qty).subscribe({
      next: () => this.loadCart(),
      error: () => this.errorMessage = 'Failed to update cart'
    });
  }

  removeCartItem(itemId: number) {
    this.orderService.deleteCartItem(itemId).subscribe({
      next: () => this.loadCart(),
      error: () => this.errorMessage = 'Failed to remove item from cart'
    });
  }

  checkout() {
    this.orderService.checkout().subscribe({
      next: () => {
        this.successMessage = 'Order placed successfully!';
        this.loadCart();
        this.errorMessage = '';
        this.cartItems = [];
        setTimeout(() => this.router.navigate(['/order/list']), 1500);
      },
      error: () => {
        this.errorMessage = 'Failed to place order';
        this.successMessage = '';
      }
    });
  }

  cancelOrder(orderId: number) {
  this.orderService.cancelOrder(orderId).subscribe({
    next: () => {
      this.successMessage = 'Order cancelled successfully!';
      this.loadCart(); 
    },
    error: () => {
      this.errorMessage = 'Failed to cancel order';
    }
  });
}
}