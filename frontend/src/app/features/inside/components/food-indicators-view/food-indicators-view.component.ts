import { Component, input } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faFire, faBreadSlice, faDrumstickBite, faCheese, faGlassWater, faLeaf } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'food-indicators-view',
  imports: [FontAwesomeModule],
  templateUrl: './food-indicators-view.component.html',
  styleUrl: './food-indicators-view.component.scss'
})
export class FoodIndicatorsViewComponent {
  kcal = input.required<Number>();
  carbohydrates = input.required<Number>();
  lipids = input.required<Number>();
  proteins = input.required<Number>();
  water = input.required<Number>();
  fibers = input.required<Number>();

  faFire = faFire;
  faBreadSlice = faBreadSlice;
  faDrumstickBite = faDrumstickBite;
  faCheese = faCheese;
  faGlassWater = faGlassWater;
  faLeaf = faLeaf;
}
