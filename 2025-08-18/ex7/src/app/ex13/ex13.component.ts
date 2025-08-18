import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-ex13',
  imports: [FormsModule, CommonModule],
  templateUrl: './ex13.component.html',
  styleUrl: './ex13.component.css'
})
export class Ex13Component {
  // Ex13
  color: string = 'default';
}
