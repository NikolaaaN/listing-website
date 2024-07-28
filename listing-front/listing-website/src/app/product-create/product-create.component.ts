import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-create',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.scss',
})
export class ProductCreateComponent {
  productForm: FormGroup;

  constructor(private fb: FormBuilder, private productService: ProductService) {
    this.productForm = this.fb.group({
      name: ['', Validators.required],
      price: ['', [Validators.required, Validators.required]],
      description: ['', Validators.required],
      image: [null, Validators.required],
      email: [null],
    });
  }

  onSubmit() {
    if (this.productForm.valid) {
      const formData = new FormData();
      formData.append('name', this.productForm.get('name')?.value);
      formData.append('price', this.productForm.get('price')?.value);
      formData.append(
        'description',
        this.productForm.get('description')?.value
      );
      formData.append('image', this.productForm.get('image')?.value);
      formData.append('email', this.productForm.get('email')?.value);
      this.productService.submitProduct(formData).subscribe(
        (response) => {
          console.log('Product submitted successfully', response);
        },
        (error) => {
          console.error('Error submitting product', error);
        }
      );
    }
  }

  onFileChange(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.productForm.patchValue({
        image: file,
      });
    }
  }
}
