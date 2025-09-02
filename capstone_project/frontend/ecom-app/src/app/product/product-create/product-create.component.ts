import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-create',
  imports: [FormsModule, CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.css'
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  categories = ['Electronics', 'Apparel', 'Kitchen', 'Books', 'Toys', 'Furniture', 'Sports', 'Beauty'];
  uoms = ['pc', 'kg', 'litre', 'box', 'pack', 'meter']; // Add this

  constructor(private fb: FormBuilder, private productService: ProductService, private router: Router) {
    this.productForm = this.fb.group({
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

  ngOnInit(): void { }

  onSubmit() {
    if (this.productForm.invalid) return;

    this.productService.createProduct(this.productForm.value).subscribe({
      next: () => {
        this.successMessage = 'Product created successfully!';
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/product/list']), 1500);
      },
      error: () => {
        this.errorMessage = 'Failed to create product';
        this.successMessage = '';
      }
    });
  }
}