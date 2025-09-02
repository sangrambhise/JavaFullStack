import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  imports: [RouterLink, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;
  userType: number = -1;
  userName: string = '';
  errorMessage: string = '';

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.updateUserState();
  }

  updateUserState() {
    this.userService.getCurrentUser().subscribe(user => {
      console.log('Current user:', user);
      if (user) {
        this.isLoggedIn = true;
        this.userType = user.userType;
        this.userName = user.firstName + ' ' + user.lastName;
      } else {
        this.isLoggedIn = false;
        this.userType = -1;
        this.userName = '';
      }
    });
  }

  logout() {
    this.userService.logout().subscribe({
      next: () => {
        this.updateUserState();
        this.router.navigate(['/user/auth/login']);
      },
      error: () => {
        this.errorMessage = 'Logout failed';
      }
    });
  }
}