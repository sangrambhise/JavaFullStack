import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlightStrikethrough]'
})
export class HighlightStrikethroughDirective {
  // Ex4
  constructor(private elementRef: ElementRef) {
    const el = this.elementRef.nativeElement;
    el.style.color = 'yellow';
    el.style.textDecoration = 'line-through';
    el.style.fontWeight = 'bold';
  }
}
