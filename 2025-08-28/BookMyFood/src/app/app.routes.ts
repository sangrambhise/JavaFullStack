import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FoodListComponent } from './food-list/food-list.component';
import { RegisterComponent } from './register/register.component';
import { OrderListComponent } from './order-list/order-list.component';
import { PaymentComponent } from './payment/payment.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'foods', component: FoodListComponent },
  { path: 'orders', component: OrderListComponent },
  { path: 'payments', component: PaymentComponent },

];
