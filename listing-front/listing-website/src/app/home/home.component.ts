import { Component } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatDividerModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  items: any = [
    {
      title: 'Bed',
      description: 'furniture for sleeping',
    },
    {
      title: 'Table',
      description: 'Furntiure for eating',
    },
  ];
}
