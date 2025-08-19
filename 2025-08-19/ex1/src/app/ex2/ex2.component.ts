import { Component } from '@angular/core';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-ex2',
  imports: [NgClass],
  templateUrl: './ex2.component.html',
  styleUrl: './ex2.component.css'
})
export class Ex2Component {
  // Ex2
  flag1 = true; 
  flag2 = true;

  toggleFlag1() {
    this.flag1 = !this.flag1;
  }

  toggleFlag2() {
    this.flag2 = !this.flag2;
  }
}

