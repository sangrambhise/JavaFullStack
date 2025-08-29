import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable} from 'rxjs';
import { BASE_URL } from '../util/appconstant';
import { Router } from '@angular/router';
import { Token } from '../interfaces/token';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
   private token: string | null = localStorage.getItem('authToken'); 
  constructor(private http: HttpClient, private router: Router) {}

  setToken(token: string): void {
  this.token = token;
  localStorage.setItem('authToken', token);
}

  getToken(): string | null {
    return this.token;
  }

  removeToken(): void {
    this.token = null;
    localStorage.removeItem('authToken'); 
  }

  getHeaders(): HttpHeaders {
    return new HttpHeaders().set('Authorization', `Bearer ${this.getToken()}`);
  }

register(userData: { username: string, password: string, email: string }): Observable<any> {
    return this.http.post(`${BASE_URL}/user/register`, userData); 
  }

  login(credentials: { email: string, password: string }): Observable<Token> {
    return this.http.post<Token>(`${BASE_URL}/user/login`, credentials); 
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }

  logout(): void {
    this.removeToken();
    this.router.navigate(['/login']);
  }
}
