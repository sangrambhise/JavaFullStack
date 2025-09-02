import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-edit',
  imports: [FormsModule],
  templateUrl: './user-edit.component.html',
  styleUrl: './user-edit.component.css'
})
export class UserEditComponent implements OnInit {

  userForm: FormGroup;
  userId: number | null = null;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.userForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', [Validators.required, Validators.email]],
      userId: ['', Validators.required],
      passWord: ['', Validators.required],
      address: [''],
      userType: [1, Validators.required] 
    });
  }

  ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.userId) {
      this.loadUser(this.userId);
    }
  }

  loadUser(id: number) {
    this.userService.getUserById(id).subscribe({
      next: (user) => {
        this.userForm.patchValue(user);
        this.userForm.get('passWord')?.setValidators([]);
        this.userForm.get('passWord')?.updateValueAndValidity();
      },
      error: (err) => this.errorMessage = 'Failed to load user'
    });
  }

  submitForm() {
    if (this.userForm.invalid) return;

    const formData = this.userForm.value;

    if (this.userId) {
      this.userService.updateUser({ ...formData, id: this.userId }).subscribe({
        next: (res) => {
          this.successMessage = 'User updated successfully!';
          this.errorMessage = '';
          setTimeout(() => this.router.navigate(['/user/list']), 2000);
        },
        error: (err) => {
          this.errorMessage = 'Failed to update user';
          this.successMessage = '';
        }
      });
    } else {
      this.userService.createUser(formData).subscribe({
        next: (res) => {
          this.successMessage = 'User created successfully!';
          this.errorMessage = '';
          setTimeout(() => this.router.navigate(['/user/list']), 2000);
        },
        error: (err) => {
          this.errorMessage = 'Failed to create user';
          this.successMessage = '';
        }
      });
    }
  }
}