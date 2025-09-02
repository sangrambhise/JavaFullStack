import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list',
  imports: [CommonModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  users: any[] = [];
  errorMessage: string = '';
  successMessage: string = '';

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.getUsers().subscribe({
      next: (data: any) => {
        this.users = data;
      },
      error: (err) => {
        this.errorMessage = 'Failed to load users';
      }
    });
  }

  deleteUser(id: number) {
    if (!confirm('Are you sure you want to delete this user?')) return;

    this.userService.deleteUser(id).subscribe({
      next: (res) => {
        this.successMessage = 'User deleted successfully!';
        this.errorMessage = '';
        this.loadUsers();
      },
      error: (err) => {
        this.errorMessage = 'Failed to delete user';
        this.successMessage = '';
      }
    });
  }

  editUser(id: number) {
    this.router.navigate(['/user/edit', id]);
  }

}