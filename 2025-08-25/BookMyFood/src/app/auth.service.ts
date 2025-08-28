import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:9000/user/login';
 private registerUrl = 'http://localhost:9000/user/register';
  constructor(private http: HttpClient) {}

  //   login(username: string, password: string): Observable<User> {
  //   return this.http.post<User>(this.loginUrl, { email: username, passWord: password });
  // }

  login(username: string, password: string): Observable<User> {
  return this.http.post<User>(this.loginUrl, { email: username, passWord: password }).pipe(
    tap((res: any) => {
      if (res.token) {
        this.saveToken('Bearer ' + res.token);  // Store token with Bearer prefix
      }
    })
  );
}

  register(username: string, password: string): Observable<any> {
    return this.http.post<any>(this.registerUrl, { email: username, passWord: password });
  }

  saveToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string {
    return localStorage.getItem('token') || '';
  }

  isAuthenticated(): boolean {
    return !!this.getToken(); 
  }
}
