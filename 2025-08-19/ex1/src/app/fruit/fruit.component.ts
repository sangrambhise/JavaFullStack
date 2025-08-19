import { Component,Input,Output,EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
// Ex6
import { IFruit } from '../fruit';
@Component({
  selector: 'app-fruit',
  imports: [CommonModule],
  templateUrl: './fruit.component.html',
  styleUrl: './fruit.component.css'
})
export class FruitComponent {
  // Ex5
  // @Input() name!: string;
  // @Input() image!: string;
  // @Input() description!: string;

  // Ex6
  @Input() fruit!: IFruit;

  // Ex7
  @Output() removeFruit = new EventEmitter<string>();
  onRemove() {
    this.removeFruit.emit(this.fruit.name); 
  }
  
}
