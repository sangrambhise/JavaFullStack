import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { IUser } from '../interfaces/user';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user: IUser = { 
    username: '', 
    password: '', 
    email: ''
  };

  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private authService: AuthService) {}

  register(): void {
    this.successMessage = null;
    this.errorMessage = null;

    if (!this.user.password || this.user.password.trim() === '') {
      this.errorMessage = 'Password cannot be empty';
      return;
    }

    this.authService.register(this.user).subscribe({
      next: (response) => {
        this.successMessage = response.message || 'User registered successfully!';
        this.user = { username: '', password: '', email: '' };
      },
      error: (error) => {
        if (error.error && error.error.message) {
          this.errorMessage = error.error.message;
        } else {
          this.errorMessage = 'Registration failed. Please try again.';
        }
      }
    });
  }
}
