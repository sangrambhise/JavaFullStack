import { Component } from '@angular/core';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-ex3',
  imports: [NgClass],
  templateUrl: './ex3.component.html',
  styleUrl: './ex3.component.css'
})
export class Ex3Component {
  // Ex3
  isHighlighted = true;
  isLargeText = false;

  toggleHighlight() {
    this.isHighlighted = !this.isHighlighted;
  }

  toggleTextSize() {
    this.isLargeText = !this.isLargeText;
  }

  getNgClass() {
    return {
      'highlight': this.isHighlighted,
      'large-text': this.isLargeText
    };
  }
}
