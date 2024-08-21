import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Product } from '../models/product.model';
import { ProductComponent } from '../product/product.component';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-table',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './product-table.component.html',
  styleUrl: './product-table.component.scss',
})
export class ProductTableComponent {
  page: number = 0;

  @Input() products: any[] = [];

  constructor(private productService: ProductService, private router: Router) {}

  click() {
    console.log(this.products);
  }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getProducts(this.page).subscribe((data: any) => {
      this.products = data.content;
    });
  }

  viewProductDetails(product: Product) {
    this.router.navigate(['product-details'], {
      state: { product },
    });
  }
}
