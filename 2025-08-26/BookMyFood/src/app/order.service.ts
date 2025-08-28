// import { Injectable } from '@angular/core';
// import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Order } from './order';
// import { AuthService } from './auth.service';

// @Injectable({
//   providedIn: 'root'
// })
// export class OrderService {
//   private orderUrl = 'http://localhost:9999/orders';

//   constructor(private http: HttpClient, private auth: AuthService) {}

//   placeOrder(order: Order): Observable<any> {
//     const headers = new HttpHeaders({
//       Authorization: this.auth.getToken()
//     });

//     return this.http.post(this.orderUrl, order, { headers });
//   }
// }
