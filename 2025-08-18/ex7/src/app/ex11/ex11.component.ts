import { Component } from '@angular/core';
// Ex11
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-ex11',
  imports: [FormsModule,CommonModule],
  templateUrl: './ex11.component.html',
  styleUrl: './ex11.component.css'
})
export class Ex11Component {
  // Ex11
  showMessage: boolean = false;
}
