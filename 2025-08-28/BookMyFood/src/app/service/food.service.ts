import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IFood } from '../interfaces/food';
import { Observable } from 'rxjs';
import { BASE_URL } from '../util/appconstant';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class FoodService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  getAllFoods(): Observable<IFood[]> {
    let token = localStorage.getItem('authToken');
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);

    let url: string = `${BASE_URL}/food`;
    return this.http.get<IFood[]>(url, { headers });
  }
}