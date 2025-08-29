import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';
import { IOrder } from '../interfaces/order';;
import { CommonModule } from '@angular/common';
import { AuthService } from '../service/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-order-list',
  imports: [CommonModule,FormsModule],
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent implements OnInit {
    orders: IOrder[] = [];
  newOrder: IOrder = {
    foodId: 0,
    orderQty: 0,
    totalOrderPrice: 0,
    orderStatus: 0,
    userId: 0,
    id: ''
  };

  constructor(private orderService: OrderService, private authService: AuthService) {}

  ngOnInit(): void {
    if (this.authService.isLoggedIn()) {
      this.loadOrders();
    }
  }

  loadOrders(): void {
    this.orderService.getAllOrders().subscribe((orders) => {
      this.orders = orders;
    });
  }

  createOrder(): void {
    this.newOrder.userId = parseInt(localStorage.getItem('userId') || '0');
    this.orderService.createOrder(this.newOrder).subscribe((order) => {
      this.orders.push(order);
      this.newOrder = {
        id: '',
        foodId: 0,
        orderQty: 0,
        totalOrderPrice: 0,
        orderStatus: 0,
        userId: 0
      };
    });
  }
}
