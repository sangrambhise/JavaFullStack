import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormsModule,
  FormControl,
} from '@angular/forms';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [
    MatListModule,
    MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    NgFor,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'ex1';
  // Ex1
  cities: string[] = [
    'New York',
    'London',
    'Tokyo',
    'Sydney',
    'Paris',
    'Dubai',
  ];

  // Ex2
  name = '';
  age = '';
  email = '';

  submit() {
    alert(
      `Submitted:\nName: ${this.name}\nAge: ${this.age}\nEmail: ${this.email}`
    );
  }

  // Ex3
  inputControl = new FormControl('');
  reversedText = '';

  // constructor() {
  //   this.inputControl.valueChanges.subscribe(value => {
  //     this.reversedText = (value || '').split('').reverse().join('');
  //   });
  // }

  // Ex4
  regForm: FormGroup;
  subjects = ['Physics', 'Maths', 'Science', 'English', 'Politics'];

  constructor(private fb: FormBuilder) {
    // Ex3
    this.inputControl.valueChanges.subscribe((value: any) => {
      this.reversedText = (value || '').split('').reverse().join('');
    });

    // Ex4
    this.regForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dob: ['', Validators.required],
      subject: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.regForm.valid) {
      const { name, email, dob, subject } = this.regForm.value;
      alert(
        `Form submitted: Name: ${name} Email: ${email} Date of Birth: ${dob} Subject: ${subject}`);
    }
  }
}
