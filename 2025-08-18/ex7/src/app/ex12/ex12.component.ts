import { Component } from '@angular/core';

@Component({
  selector: 'app-ex12',
  imports: [],
  templateUrl: './ex12.component.html',
  styleUrl: './ex12.component.css'
})
export class Ex12Component {
  // Ex12
  allCountries: string[] = ['India', 'USA', 'Russia', 'Israel', 'France'];
  countries: string[] = [];
  loadCountries() {
    this.countries = this.allCountries;
  }
}
