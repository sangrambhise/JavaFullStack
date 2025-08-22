import { Routes } from '@angular/router';
import { ProductlistComponent } from './productlist/productlist.component';
import { ProductaddComponent } from './productadd/productadd.component';
import { ProducteditComponent } from './productedit/productedit.component';
import { ProductdeleteComponent } from './productdelete/productdelete.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { OrderComponent } from './order/order.component';  

export const routes: Routes = [
  { path: '', component: ProductlistComponent },
  { path: 'add', component: ProductaddComponent },
  { path: 'edit/:id', component: ProducteditComponent },
  { path: 'delete/:id', component: ProductdeleteComponent },
// Ex3
  { path: 'purchase', component: PurchaseComponent },
  { path: 'orders', component: OrderComponent }   
];
