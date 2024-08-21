import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatSliderModule } from '@angular/material/slider';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
@Component({
  selector: 'app-filter',
  standalone: true,
  imports: [
    MatButtonModule,
    FlexLayoutModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    MatSliderModule,
  ],
  templateUrl: './filter.component.html',
  styleUrl: './filter.component.scss',
})
export class FilterComponent {
  filterForm: FormGroup;
  searchTerm: string = '';
  selectedCategory: string = '';
  categories: string[] = ['Category 1', 'Category 2', 'Category 3'];

  constructor(private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      selectedCategory: [''],
      priceRange1: 0,
      priceRange2: 1000,
    });
  }

  toggleCategory(category: string) {
    console.log('Search Term:', this.searchTerm);
    console.log('Selected Category:', this.selectedCategory);
  }

  applyFilters() {}

  ngOnInit(): void {}
}
