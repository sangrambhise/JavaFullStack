import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ex14',
  imports: [FormsModule, CommonModule],
  templateUrl: './ex14.component.html',
  styleUrl: './ex14.component.css'
})
export class Ex14Component {
  // Ex14
   names: string[] = ['Jitendra', 'Barinder', 'Prathamesh', 'Suresh', 'Ajay', 'Vijay'];
  search: string = '';
  get filteredNames(): string[] {
    const search = this.search.toLowerCase();
    return this.names.filter(name => name.toLowerCase().startsWith(search));
  }
}
