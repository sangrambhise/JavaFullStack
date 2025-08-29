import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { BASE_URL } from '../util/appconstant';
import { IPayment } from '../interfaces/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient, private authService: AuthService) {}

  payForOrder(payment: IPayment): Observable<any> {
    return this.http.post(`${BASE_URL}/payment/pay`, payment, {
      headers: this.authService.getHeaders()
    });
  }
  getPaymentStatus(orderId: string): Observable<any> {
    return this.http.get(`${BASE_URL}/payment/status/${orderId}`, {
      headers: this.authService.getHeaders()
    });
  }
}
