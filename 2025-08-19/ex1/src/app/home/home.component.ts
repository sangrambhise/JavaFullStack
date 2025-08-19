import { Component } from '@angular/core';
// Ex1
// import { DisplayListComponent } from '../display-list/display-list.component';
// Ex5
import { FruitComponent } from '../fruit/fruit.component';
// Ex6
import { IFruit } from '../fruit';
@Component({
  selector: 'app-home',
  // Ex1
  // imports: [DisplayListComponent],
  imports: [FruitComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // Ex5
fruits:IFruit[] = [
    {
      name: 'Apple',
      image: 'https://images.pexels.com/photos/209439/pexels-photo-209439.jpeg',
      description: 'An apple is an edible fruit produced by an apple tree (Malus domestica). Apples are high in fiber and vitamin C.'
    },
    {
      name: 'Banana',
      image: 'https://images.pexels.com/photos/1166648/pexels-photo-1166648.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260',
      description: 'Bananas are elongated, edible fruits produced by several kinds of large herbaceous flowering plants in the genus Musa.'
    },
    {
      name: 'Orange',
      image: 'https://images.pexels.com/photos/161559/background-bitter-breakfast-bright-161559.jpeg?cs=srgb&dl=pexels-pixabay-161559.jpg&fm=jpg',
      description: 'The orange is the fruit of various citrus species. It is known for its sweet, tangy flavor and high vitamin C content.'
    },
    {
      name: 'Strawberry',
      image: 'https://images.pexels.com/photos/835752/pexels-photo-835752.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260',
      description: 'The garden strawberry is a widely grown hybrid species of the genus Fragaria, known for its bright red color and sweetness.'
    },
    {
      name: 'Pineapple',
      image: 'https://images.pexels.com/photos/189265/pexels-photo-189265.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260',
      description: 'The pineapple (Ananas comosus) is a tropical plant with an edible fruit. It is rich in vitamin C and bromelain.'
    }
  ];

  // ex7
    removeFruit(fruitName: string) {
    this.fruits = this.fruits.filter(fruit => fruit.name !== fruitName);
  }
}
