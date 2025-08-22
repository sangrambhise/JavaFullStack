import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from './iproduct';
import { IOrder } from './iorder';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // EX1
  private url = 'http://localhost:8080/product';
  constructor(private http: HttpClient) { }
  
  getProducts(): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(this.url);
  }

  addProduct(product: IProduct): Observable<IProduct> {
    return this.http.post<IProduct>(this.url, product);
  }

  findProduct(id: string): Observable<IProduct> {
    return this.http.get<IProduct>(`${this.url}/${id}`);
  }

  updateProduct(product: IProduct): Observable<IProduct> {
    return this.http.put<IProduct>(`${this.url}/${product.id}`, product);
  }

  deleteProduct(id: string): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

  purchase(body: {productId: number, quantity: number}): Observable<void> {
  return this.http.post<void>(`${this.url}/purchase`, body);
  }
  getOrders(): Observable<IOrder[]> {
  return this.http.get<IOrder[]>(`${this.url}/orders`);
}
}

