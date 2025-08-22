import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-productdelete',
  imports: [RouterOutlet],
  templateUrl: './productdelete.component.html',
  styleUrl: './productdelete.component.css'
})

export class ProductdeleteComponent implements OnInit {
  constructor(private route: ActivatedRoute, private service: ProductService, private router: Router) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.service.deleteProduct(id).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }
}