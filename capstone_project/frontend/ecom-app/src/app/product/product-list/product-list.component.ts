import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UserService } from '../../services/user.service';
import { OrderService } from '../../services/order.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {
  products: any[] = [];
  filteredProducts: any[] = [];
  paginatedProducts: any[] = [];

  errorMessage: string = '';
  user: any;

  filters = { category: '', description: '', price: null as number | null };

  pageSize = 6;
  currentPage = 1;
  totalPages = 1;
  totalPagesArray: number[] = [];

  constructor(
    private productService: ProductService,
    private authService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.user = this.authService.getCurrentUser();
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getProducts().subscribe({
      next: (data: any) => {
        this.products = data;
        this.applyFilters();
      },
      error: () => (this.errorMessage = 'Failed to load products')
    });
  }

  applyFilters() {
    this.filteredProducts = this.products.filter(p =>
      (!this.filters.category || p.prodCat.toLowerCase().includes(this.filters.category.toLowerCase())) &&
      (!this.filters.description || (p.prodDesc || '').toLowerCase().includes(this.filters.description.toLowerCase())) &&
      (!this.filters.price || p.price <= this.filters.price)
    );
    this.setupPagination();
  }

  setupPagination() {
    this.totalPages = Math.ceil(this.filteredProducts.length / this.pageSize) || 1;
    this.totalPagesArray = Array.from({ length: this.totalPages }, (_, i) => i + 1);
    this.changePage(1);
  }

  changePage(page: number) {
    if (page < 1 || page > this.totalPages) return;
    this.currentPage = page;
    const start = (page - 1) * this.pageSize;
    this.paginatedProducts = this.filteredProducts.slice(start, start + this.pageSize);
  }

  deleteProduct(id: number) {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe({
        next: () => this.loadProducts(),
        error: () => (this.errorMessage = 'Failed to delete product')
      });
    }
  }

  addToCart(productId: number) {
    this.productService.addToCart(productId).subscribe({
      next: () => alert('Product added to cart!'),
      error: () => alert('Failed to add product to cart')
    });
  }
}