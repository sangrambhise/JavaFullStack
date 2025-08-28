import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';
import { IPayment } from '../interfaces/payment';
@Component({
  selector: 'app-payment',
  imports: [],
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css'
})
export class PaymentComponent implements OnInit {
   payment: IPayment = {
    orderId: '',
    totalOrderPrice: 0,
    paymentStatus: 0,
    modeOfPayment: '',
    accountNumber: '',
    cvv: 0
  };

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {}

  makePayment(): void {
    this.orderService.payForOrder(this.payment).subscribe((response) => {
      console.log('Payment successful', response);
    });
  }
}