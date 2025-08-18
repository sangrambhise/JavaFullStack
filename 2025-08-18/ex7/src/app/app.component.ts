import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Ex8Component } from './ex8/ex8.component';
import { Ex9Component } from './ex9/ex9.component';
import { Ex10Component } from './ex10/ex10.component';
import { Ex11Component } from './ex11/ex11.component';
import { Ex12Component } from './ex12/ex12.component';
import { Ex13Component } from './ex13/ex13.component';
import { Ex14Component } from './ex14/ex14.component';
  // Ex15
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'app-root',
    standalone: true,
  imports: [RouterOutlet,HomeComponent,Ex8Component,
    Ex9Component,
    Ex10Component,
    Ex11Component,
    Ex12Component,
    Ex13Component,
    Ex14Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ex7';
   //Ex7
   message: string = 'Hello';
  }

