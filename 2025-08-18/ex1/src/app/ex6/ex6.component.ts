import { Component } from '@angular/core';

@Component({
  selector: 'app-ex6',
  standalone: true,
  imports: [],
  // templateUrl: './ex6.component.html',
  //Ex6
  template: `
    <div class="container mt-5">
      <div class="alert alert-success text-center">
        <h3>Welcome to Inline Component!</h3>
        <p>This HTML is defined directly in the component file using the <code>template</code> property.</p>
      </div>
    </div>
  `,
  styleUrl: './ex6.component.css'
})
export class Ex6Component {

}
