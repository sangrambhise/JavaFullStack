import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-edit',
  imports: [CommonModule, FormsModule, ReactiveFormsModule,RouterLink],
  templateUrl: './product-edit.component.html',
  styleUrl: './product-edit.component.css'
})
export class ProductEditComponent  implements OnInit {
  productForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';
  productId!: number;

  categories = ['Electronics', 'Apparel', 'Kitchen', 'Books', 'Toys', 'Furniture', 'Sports', 'Beauty'];
  uoms = ['pc', 'kg', 'litre', 'box', 'pack', 'meter'];

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.productForm = this.fb.group({
      id: [''],
      prodName: ['', Validators.required],
      prodDesc: [''],
      prodCat: ['', Validators.required],
      make: [''],
      availableQty: [0, Validators.required],
      price: [0, Validators.required],
      uom: ['pc', Validators.required],
      prodRating: [0],
      imageURL: [''],
      dateOfManufacture: ['']
    });
  }

  ngOnInit(): void {
    this.productId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadProduct();
  }

  loadProduct() {
    this.productService.getProductById(this.productId).subscribe({
      next: (data: any) => this.productForm.patchValue(data),
      error: () => this.errorMessage = 'Failed to load product'
    });
  }

  updateProduct() {
    if (this.productForm.invalid) return;

    this.productService.updateProduct(this.productId, this.productForm.value).subscribe({
      next: () => {
        this.successMessage = 'Product updated successfully!';
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/product/list']), 1500);
      },
      error: () => {
        this.errorMessage = 'Failed to update product';
        this.successMessage = '';
      }
    });
  }
}