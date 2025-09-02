import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [RouterLink, CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  user: any = null;
  errorMessage = '';

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getLoggedInUser();
  }

  getLoggedInUser() {
    this.userService.getCurrentUser().subscribe({
      next: (res: any) => {
        this.user = res;
      },
      error: (err: any) => {
        console.error('Error fetching user info', err);
        this.errorMessage = 'Unable to fetch user info';
      }
    });
  }
}