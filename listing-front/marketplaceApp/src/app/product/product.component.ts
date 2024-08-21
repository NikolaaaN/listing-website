import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss',
})
export class ProductComponent {
  @Input() product: any = [
    {
      price: 200,
      name: 'krevet',
      descirption: 'krevet',
    },
  ];
}
