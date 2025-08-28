import { Component, OnInit } from '@angular/core';
import { Food } from '../food';
import { FoodService } from '../food.service';
// import { OrderService } from '../order.service';
import { Order } from '../order';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-food-list',
  imports: [CommonModule],
  templateUrl: './food-list.component.html',
  styleUrl: './food-list.component.css'
})
export class FoodListComponent  implements OnInit {
  foods: Food[] = [];
  defaultImageUrl = 'https://via.placeholder.com/150?text=No+Image';

  constructor(
    private foodService: FoodService,
    // private orderService: OrderService
  ) {}

  ngOnInit() {
    this.foodService.getAllFoods().subscribe(data => {
      this.foods = data;
    });
  }

  order(food: Food) {
  alert(`Order placed for ${food.name}`);
  }
   trackByFoodId(index: number, food: Food) {
    return food.id;
  }


  // order(food: Food) {
  //   const order: Order = {
  //     orderNumber: 'ORD-' + Math.floor(Math.random() * 10000),
  //     orderValue: food.price
  //   };

  //   this.orderService.placeOrder(order).subscribe({
  //     next: () => alert('Order placed for ' + food.name),
  //     error: () => alert('Order failed')
  //   });
  // }
}
