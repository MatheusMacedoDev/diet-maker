import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodIndicatorsViewComponent } from './food-indicators-view.component';

describe('FoodIndicatorsViewComponent', () => {
  let component: FoodIndicatorsViewComponent;
  let fixture: ComponentFixture<FoodIndicatorsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FoodIndicatorsViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoodIndicatorsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
