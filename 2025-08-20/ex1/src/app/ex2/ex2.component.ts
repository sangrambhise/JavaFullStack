import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-ex2',
  imports: [FormsModule,CommonModule],
  templateUrl: './ex2.component.html',
  styleUrl: './ex2.component.css'
})
export class Ex2Component {
  // Ex2
    selectedDate: string | null = null;
}
