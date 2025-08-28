import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IOrder } from '../interfaces/order';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { BASE_URL } from '../util/appconstant';
import { IPayment } from '../interfaces/payment';
@Injectable({
  providedIn: 'root'
})
export class OrderService {

constructor(private http: HttpClient, private authService: AuthService) {}

  // Get all orders
  getAllOrders(): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(`${BASE_URL}/order`, {
      headers: this.authService.getHeaders()
    });
  }
  // Get order by ID
  getOrderById(id: number): Observable<IOrder> {
    return this.http.get<IOrder>(`${BASE_URL}/order/${id}`, {
      headers: this.authService.getHeaders()
    });
  }

  // Create new order
  createOrder(order: IOrder): Observable<IOrder> {
    return this.http.post<IOrder>(`${BASE_URL}/order`, order, {
      headers: this.authService.getHeaders()
    });
  }

  // Pay for an order
  payForOrder(payment: IPayment): Observable<IPayment> {
    return this.http.post<IPayment>(`${BASE_URL}/order/pay`, payment, {
      headers: this.authService.getHeaders()
    });
  }
}
