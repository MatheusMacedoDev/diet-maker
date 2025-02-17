import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FoodIndicatorsViewComponent } from './features/inside/components/food-indicators-view/food-indicators-view.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FoodIndicatorsViewComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
