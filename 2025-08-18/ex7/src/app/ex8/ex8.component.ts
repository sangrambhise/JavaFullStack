import { Component } from '@angular/core';
// Ex8
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-ex8',
  imports: [FormsModule],
  templateUrl: './ex8.component.html',
  styleUrl: './ex8.component.css'
})
export class Ex8Component {
message: string = '';
}
