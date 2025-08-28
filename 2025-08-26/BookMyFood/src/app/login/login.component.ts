import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { FormsModule } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username = '';
  password = '';
  http: any;
  constructor(private authService: AuthService, private router: Router) {}

  login() {
  this.authService.login(this.username, this.password).subscribe({
    next: (res) => {
      const token = res.token;
      this.authService.saveToken('Bearer ' + token);
      this.router.navigate(['/foods']);
      this.fetchFoodData(token); 
    },
    error: (err) => {
      console.error(err);
      alert('Login failed');
    }
  });
}

fetchFoodData(token: string) {
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  this.http.get('http://localhost:9020/food', { headers }).subscribe({
    next: (response: any) => {
      console.log(response);
    },
    error: (err: any) => {
      console.error(err);
      alert('Error fetching food data');
    }
  });
}
}