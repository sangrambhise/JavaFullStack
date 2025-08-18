import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
// Ex15
export class HomeComponent {
books = [...Array(20)].map((_, i) => ({
  title: `Book Title ${i + 1}`,
  description: `This is a description of Book ${i + 1}.`,
  image: `https://picsum.photos/150/200?random=${i + 1}`
}));
}

