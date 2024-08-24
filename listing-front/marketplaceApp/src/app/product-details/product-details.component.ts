import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../models/product.model';
import { Seller } from '../models/seller.mode';
import { User } from '../models/user.model';
import { SellerService } from '../services/seller.service';

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

  seller: Seller = {
    name: '',
    phone: '',
    city: '',
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private sellerService: SellerService
  ) {
    const navigation = this.router.getCurrentNavigation();
    console.log(navigation?.extras.state?.['product']);
    this.product = navigation?.extras.state?.['product'];
    this.loadSeller();
  }

  ngOnInit(): void {}

  loadSeller() {
    this.sellerService
      .getSellerInfo(this.product.id!)
      .subscribe((data: any) => {
        console.log(data);
        this.seller = data;
      });
  }
}
