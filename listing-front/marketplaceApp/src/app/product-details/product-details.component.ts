import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss',
})
export class ProductDetailsComponent {
  product: Product = {
    name: 'Product',
    price: 200,
    image: 'image',
    description: 'description',
  };

  constructor(private route: ActivatedRoute, private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    console.log(navigation?.extras.state?.['product']);
    this.product = navigation?.extras.state?.['product'];
  }

  ngOnInit(): void {}
}
