import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../services/order.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order-list',
  imports: [CommonModule],
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent implements OnInit {
  orders: any[] = [];
  paginatedOrders: any[] = [];
  errorMessage: string = '';

  // Pagination
  pageSize = 5;
  currentPage = 1;
  totalPages = 1;
  totalPagesArray: number[] = [];

  constructor(private orderService: OrderService, private router: Router) {}

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders() {
    this.orderService.getOrders().subscribe({
      next: (data: any) => {
        this.orders = data;
        this.setupPagination();
      },
      error: () => (this.errorMessage = 'Failed to load orders')
    });
  }

  setupPagination() {
    this.totalPages = Math.ceil(this.orders.length / this.pageSize) || 1;
    this.totalPagesArray = Array.from({ length: this.totalPages }, (_, i) => i + 1);
    this.changePage(1);
  }

  changePage(page: number) {
    if (page < 1 || page > this.totalPages) return;
    this.currentPage = page;
    const start = (page - 1) * this.pageSize;
    this.paginatedOrders = this.orders.slice(start, start + this.pageSize);
  }

  cancelOrder(orderId: number) {
    if (confirm('Are you sure you want to cancel this order?')) {
      this.orderService.cancelOrder(orderId).subscribe({
        next: () => this.loadOrders(),
        error: () => (this.errorMessage = 'Failed to cancel order')
      });
    }
  }

  viewOrderDetails(orderId: number) {
    this.router.navigate([`/order/details/${orderId}`]);
  }
}