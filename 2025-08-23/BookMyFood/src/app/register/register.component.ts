import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
name = '';
  email = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) {}

  register() {
  const user = {
    name: this.name,
    email: this.email,
    passWord: this.password
  };

  this.http.post('http://localhost:9000/user/register', user).subscribe({
    next: () => {
      alert('Registration successful');
      this.router.navigate(['/login']);
    },
    error: () => alert('Registration failed')
  });
}
}
