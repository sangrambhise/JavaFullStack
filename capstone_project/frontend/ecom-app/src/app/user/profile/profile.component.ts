import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  imports: [FormsModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {

  profileForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
    this.profileForm = this.fb.group({
      id: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', [Validators.required, Validators.email]],
      userId: [{ value: '', disabled: true }],
      passWord: ['', Validators.required],
      address: ['']
    });
  }

  ngOnInit(): void {
    this.loadProfile();
  }

  loadProfile() {
    this.userService.getLoggedInUser().subscribe({
      next: (data: any) => {
        this.profileForm.patchValue(data);
      },
      error: () => {
        this.errorMessage = 'Failed to load profile';
      }
    });
  }

  updateProfile() {
    if (this.profileForm.invalid) return;

    this.userService.updateUser(this.profileForm.getRawValue()).subscribe({
      next: (data) => {
        this.successMessage = 'Profile updated successfully!';
        this.errorMessage = '';
      },
      error: (err) => {
        this.errorMessage = 'Failed to update profile';
        this.successMessage = '';
      }
    });
  }

  

}