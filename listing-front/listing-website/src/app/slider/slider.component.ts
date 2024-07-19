import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-slider',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './slider.component.html',
  styleUrl: './slider.component.scss',
})
export class SliderComponent {
  items: any = [
    { title: 'krevet', description: 'namestaj za spavanje' },
    { title: 'fotelja', description: 'Namestaj za sedenje' },
  ];

  constructor() {}
}
