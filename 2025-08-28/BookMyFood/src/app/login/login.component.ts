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


  credentials = { email: '', password: '' }; 

  constructor(private authService: AuthService, private router: Router) {}

login(): void {
  this.authService.login(this.credentials).subscribe({
  next: (response) => {
    if (response && response.token) {
      this.authService.setToken(response.token);
      console.log('Login successful!');
      this.router.navigate(['/foods']);
    } else {
      console.error('Login failed: No token received');
      alert('Login failed: Invalid credentials');
    }
  },
  error: (error) => {
    console.error('Login failed', error);
    alert('Login failed: Server error');
  }
});
}
}