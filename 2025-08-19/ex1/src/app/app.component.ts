import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { Ex2Component } from './ex2/ex2.component';
import { Ex3Component } from './ex3/ex3.component';
import { Ex4Component } from './ex4/ex4.component';
@Component({
  selector: 'app-root',
  imports: [HomeComponent,Ex2Component,Ex3Component,Ex4Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ex1';
}
