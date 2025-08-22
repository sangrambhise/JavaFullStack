import { Component } from '@angular/core';
import { ProductService } from '../product.service';
import { IOrder } from '../iorder';
@Component({
  selector: 'app-order',
  imports: [],
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent {
  // Ex3
  orders: IOrder[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getOrders().subscribe(data => this.orders = data);
  }
}
