import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, of, tap } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  

  private authBaseUrl = environment.apiBaseUrl + '/user/auth';
  private userBaseUrl = environment.apiBaseUrl + '/user/user';
  private currentUser: any = null;

  constructor(private http: HttpClient) { }

  login(userData: { userId: string, password: string }): Observable<any> {
    return this.http.post(`${this.authBaseUrl}/login`, userData, { withCredentials: true });
  }

  logout(): Observable<any> {
    localStorage.removeItem('token');
    return this.http.post(`${this.authBaseUrl}/logout`, {}, { withCredentials: true }).pipe(
      tap(() => this.currentUser = null)
    );
  }

  getUsers(): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.userBaseUrl}`, { headers });
  }

  getUserById(id: number): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.userBaseUrl}/${id}`, { headers });
  }

  getCurrentUser(): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.userBaseUrl}/me`, { headers });
  }

  getLoggedInUser(): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.userBaseUrl}/me`, { headers });
  }

  createUser(userData: any): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`${this.userBaseUrl}`, userData, { headers });
  }

  updateUser(user: any): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put(`${this.userBaseUrl}/${user.id}`, user, { headers });
  }

  deleteUser(id: number): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete(`${this.userBaseUrl}/${id}`, { headers });
  }

  register(userData: any): Observable<any> {
    return this.http.post(`${this.authBaseUrl}/register`, userData, { withCredentials: true });
  }
}
