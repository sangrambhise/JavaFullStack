import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, RouterLink, FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', [Validators.required, Validators.email]],
      userId: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      address: ['']
    });
  }

  async onSubmit() {
    if (this.registerForm.invalid) {
      this.errorMessage = 'Please fill all required fields correctly';
      return;
    }

    this.userService.register(this.registerForm.value).subscribe({
    next: (res: any) => {
      console.log('Registration response:', res); 
      this.successMessage = res.message || 'Registration successful! Redirecting to login...';
      this.errorMessage = '';

      setTimeout(() => this.router.navigate(['/user/login']), 2000);
    },
    error: (err: any) => {
      console.error('Registration error:', err);
      this.errorMessage = err.error?.message || 'Registration failed';
      this.successMessage = '';
    }
  });
}
}