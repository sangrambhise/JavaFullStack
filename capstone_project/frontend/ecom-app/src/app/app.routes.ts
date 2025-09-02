import { Routes } from '@angular/router';
import { DashboardComponent } from './shared/dashboard/dashboard.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { ProductEditComponent } from './product/product-edit/product-edit.component';
import { OrderListComponent } from './order/order-list/order-list.component';
import { OrderCreateComponent } from './order/order-create/order-create.component';
import { OrderDetailsComponent } from './order/order-details/order-details.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';

export const routes: Routes = [
  { path: '', redirectTo: '/user/auth/login', pathMatch: 'full' },
  { path: 'user/auth/login', component: LoginComponent },
  { path: 'user/auth/register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'product/edit/:id', component: ProductEditComponent },
  { path: 'product/list', component: ProductListComponent},
  { path: 'product/create', component: ProductCreateComponent},
  { path: 'order/list', component: OrderListComponent },
  { path: 'order/create', component: OrderCreateComponent },
  { path: 'order/details/:id', component: OrderDetailsComponent },
  { path: '**', redirectTo: '/user/auth/login' } 
];
