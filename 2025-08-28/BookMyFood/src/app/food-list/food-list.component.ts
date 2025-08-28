import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { IFood } from '../interfaces/food';
import { FoodService } from '../service/food.service';
import { CommonModule } from '@angular/common';
import { OrderService } from '../service/order.service';
import { Router } from '@angular/router';
import { IOrder } from '../interfaces/order';
@Component({
  selector: 'app-food-list',
  imports: [CommonModule],
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
      this.foodList = data;
      this.foodList.forEach((food) => this.foodMap.set(food.id!, 1));
      this.cdr.markForCheck();
    });
  }

  changeQuantity(foodId: number) {
    this.foodMap.set(foodId, this.quantity);
  }

  async orderFood(foodId: number) {
    const orderData: IOrder = {
      foodId: foodId,
      orderQty: this.foodMap.get(foodId) || 1
    };

    this.orderService.save(orderData).subscribe((result: IOrder) => {
      this.router.navigate(['/payment', result.id, result.totalOrderPrice]);  // Navigate to payment
    });
  }
}
