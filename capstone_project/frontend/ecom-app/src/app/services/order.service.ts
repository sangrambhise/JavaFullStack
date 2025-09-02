import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private orderBaseUrl = environment.apiBaseUrl + '/order/order';
  private cartBaseUrl = environment.apiBaseUrl + '/cart/cart';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): { headers: HttpHeaders } {
    const token = localStorage.getItem('token') || '';
    return { headers: new HttpHeaders().set('Authorization', `Bearer ${token}`) };
  }

  addToCart(productId: number, quantity: number): Observable<any> {
    return this.http.post(`${this.cartBaseUrl}/add`, { productId, quantity }, this.getAuthHeaders());
  }

  viewCart(): Observable<any> {
    return this.http.get(`${this.cartBaseUrl}`, this.getAuthHeaders());
  }

  updateCartItem(itemId: number, qty: number): Observable<any> {
    const params = new HttpParams().set('qty', qty);
    return this.http.put(`${this.cartBaseUrl}/update/${itemId}`, null, { ...this.getAuthHeaders(), params });
  }

  deleteCartItem(itemId: number): Observable<any> {
    return this.http.delete(`${this.cartBaseUrl}/delete/${itemId}`, this.getAuthHeaders());
  }

  getOrders(): Observable<any> {
    return this.http.get(`${this.orderBaseUrl}`, this.getAuthHeaders());
  }

  getOrderById(orderId: number): Observable<any> {
    return this.http.get(`${this.orderBaseUrl}/${orderId}`, this.getAuthHeaders());
  }

  checkout(): Observable<any> {
    return this.http.post(`${this.orderBaseUrl}/checkout`, {}, this.getAuthHeaders());
  }

  cancelOrder(orderId: number): Observable<any> {
    return this.http.post(`${this.orderBaseUrl}/${orderId}/cancel`, {}, this.getAuthHeaders());
  }
}
