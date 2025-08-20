import { Component } from '@angular/core';
import { CtofPipe } from '../ctof.pipe';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-ex3',
  imports: [CtofPipe,FormsModule, CommonModule],
  templateUrl: './ex3.component.html',
  styleUrl: './ex3.component.css'
})
export class Ex3Component {
  // Ex3
  tempCelsius: number | null = null;
}
