import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = environment.apiBaseUrl + '/product/product';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): { headers: HttpHeaders } {
    const token = localStorage.getItem('token') || '';
    return { headers: new HttpHeaders().set('Authorization', `Bearer ${token}`) };
  }

  addToCart(productId: number, quantity: number = 1): Observable<any> {
  const url = `${environment.apiBaseUrl}/order/cart`;
  return this.http.post(url, { productId, quantity }, this.getAuthHeaders());
}

  getProducts(): Observable<any> {
    return this.http.get(`${this.baseUrl}`, this.getAuthHeaders());
  }

  getProductById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`, this.getAuthHeaders());
  }

  createProduct(productData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, productData, this.getAuthHeaders());
  }

  updateProduct(id: number, productData: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, productData, this.getAuthHeaders());
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, this.getAuthHeaders());
  }
}
