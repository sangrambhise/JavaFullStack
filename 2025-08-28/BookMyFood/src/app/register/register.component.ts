import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user = { username: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {}

  register(): void {
    this.authService.register(this.user).subscribe(
      response => {
        console.log('User registered successfully!', response);
        this.router.navigate(['/login']); // Navigate to login page after successful registration
      },
      error => {
        console.error('Registration failed', error);
      }
    );
  }
}
