import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ProductComponent } from '../product/product.component';
@Component({
  selector: 'app-product-table',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './product-table.component.html',
  styleUrl: './product-table.component.scss',
})
export class ProductTableComponent {
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

  click() {
    console.log(this.products);
  }
}
