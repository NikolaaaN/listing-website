import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ProductComponent } from '../product/product.component';
import { ProductService } from '../services/product.service';
@Component({
  selector: 'app-product-table',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './product-table.component.html',
  styleUrl: './product-table.component.scss',
})
export class ProductTableComponent {
  page: number = 0;

  @Input() products: any[] = [
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
  ];

  constructor(private productService: ProductService) {}

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
}
