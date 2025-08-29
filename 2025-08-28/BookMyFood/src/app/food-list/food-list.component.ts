import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { IFood } from '../interfaces/food';
import { FoodService } from '../service/food.service';
import { CommonModule } from '@angular/common';
import { OrderService } from '../service/order.service';
import { Router } from '@angular/router';
import { IOrder } from '../interfaces/order';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-food-list',
  imports: [CommonModule,FormsModule],
  templateUrl: './food-list.component.html',
  styleUrl: './food-list.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush

})

export class FoodListComponent implements OnInit {
  foodList: IFood[] = [];
  quantity: number = 1;
  foodMap: Map<number, number> = new Map();

  constructor(
    private foodService: FoodService,
    private cdr: ChangeDetectorRef,
    private router: Router,
    private orderService: OrderService
  ) {}

  ngOnInit() {
    this.foodService.getAllFoods().subscribe((data) => {
      console.log('Food Data:', data);
      this.foodList = data;
      this.foodList.forEach((food) => this.foodMap.set(food.id!, 1));
      this.cdr.markForCheck();
    },
  (error) => {
    console.error('Error fetching foods:', error);  
  });
  }

  changeQuantity(foodId: number) {
    this.foodMap.set(foodId, this.quantity);
  }

  async orderFood(foodId: number) {
    const orderData: IOrder = {
      foodId: foodId,
      orderQty: this.foodMap.get(foodId) || 1,
      id: '',
      totalOrderPrice: 0,
      orderStatus: 0,
      userId: 0
    };

    this.orderService.save(orderData).subscribe((result: IOrder) => {
      this.router.navigate(['/payment', result.id, result.totalOrderPrice]); 
    });
  }
}
