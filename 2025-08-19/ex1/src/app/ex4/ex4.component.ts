import { Component } from '@angular/core';
import { NgStyle } from '@angular/common';

@Component({
  selector: 'app-ex4',
  imports: [NgStyle],
  templateUrl: './ex4.component.html',
  styleUrl: './ex4.component.css'
})
export class Ex4Component {
// Ex4
  textColor = 'green';
  fontSize = '20px';
  isBold = true;

  toggleStyle() {
    this.textColor = this.textColor === 'green' ? 'crimson' : 'green';
    this.fontSize = this.fontSize === '20px' ? '28px' : '20px';
    this.isBold = !this.isBold;
  }

  getStyles() {
    return {
      'color': this.textColor,
      'font-size': this.fontSize,
      'font-weight': this.isBold ? 'bold' : 'normal',
      'border': '1px solid #ccc',
      'padding': '10px'
    };
  }

}
