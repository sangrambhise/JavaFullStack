import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from './food';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
   private foodUrl = 'http://localhost:9020/food'; // URL to fetch food data from

  constructor(private http: HttpClient, private auth: AuthService) {}

getAllFoods(): Observable<Food[]> {
  const token = this.auth.getToken();
  if (!token) {
    alert('You must be logged in to access food data!');
    return new Observable();  
  }
  const headers = new HttpHeaders({
    'Authorization': token
  });

  return this.http.get<Food[]>(this.foodUrl, { headers });
}
}