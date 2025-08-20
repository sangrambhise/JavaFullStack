import { HighlightStrikethroughDirective } from './highlight-strikethrough.directive';
import { ElementRef } from '@angular/core';

describe('HighlightStrikethroughDirective', () => {
  it('should create an instance', () => {
    const mockElementRef = new ElementRef(document.createElement('p'));
    const directive = new HighlightStrikethroughDirective(mockElementRef);
    expect(directive).toBeTruthy();
  });
});