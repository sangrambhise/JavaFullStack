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
  save(order: IOrder): Observable<IOrder> {
    return this.http.post<IOrder>(`${BASE_URL}/order`, order, {
      headers: this.authService.getHeaders()
    });
  }
  getAllOrders(): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(`${BASE_URL}/order`, {
      headers: this.authService.getHeaders()
    });
  }
  getOrderById(id: number): Observable<IOrder> {
    return this.http.get<IOrder>(`${BASE_URL}/order/${id}`, {
      headers: this.authService.getHeaders()
    });
  }

  createOrder(order: IOrder): Observable<IOrder> {
    return this.http.post<IOrder>(`${BASE_URL}/order`, order, {
      headers: this.authService.getHeaders()
    });
  }

  payForOrder(payment: IPayment): Observable<IPayment> {
    return this.http.post<IPayment>(`${BASE_URL}/order/pay`, payment, {
      headers: this.authService.getHeaders()
    });
  }
}
