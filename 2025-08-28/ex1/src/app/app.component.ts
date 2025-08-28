import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ex1';
  isPalindrome(input: string): boolean {
    const cleanedInput = input.toLowerCase();
    const reversedInput = cleanedInput.split('').reverse().join('');
    return cleanedInput === reversedInput;
  }
}
