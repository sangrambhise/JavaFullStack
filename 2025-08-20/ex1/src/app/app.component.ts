import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
// Ex4
import { FormsModule } from '@angular/forms'; 
import { CapitalizePipe } from './capitalize.pipe'; 
// Ex2
import { Ex2Component } from './ex2/ex2.component';
// Ex3
import { Ex3Component } from './ex3/ex3.component';
// Ex4
import { HighlightStrikethroughDirective } from './highlight-strikethrough.directive';
// Ex5
import { MovieComponent } from './movie/movie.component';
@Component({
  selector: 'app-root',
  imports: [FormsModule, CapitalizePipe, Ex2Component, Ex3Component, HighlightStrikethroughDirective, MovieComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ex1';
  // Ex1
    userInput: string = '';
}
