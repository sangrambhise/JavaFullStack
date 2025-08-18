import { Component } from '@angular/core';

@Component({
  selector: 'app-ex9',
  imports: [],
  templateUrl: './ex9.component.html',
  styleUrl: './ex9.component.css'
})
export class Ex9Component {
//Ex9
message: string = 'Hello';
   greet() {
    console.log('Current input is', this.message);
  }
}
