import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  credentials = { username: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {
    this.authService.login(this.credentials).subscribe(
      response => {
        this.authService.setToken(response.token); // Assuming the token is returned as "token"
        console.log('Login successful!');
        this.router.navigate(['/foods']); // Redirect to orders page after successful login
      },
      error => {
        console.error('Login failed', error);
      }
    );
  }
}