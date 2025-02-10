import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrangeButtonComponent } from './orange-button.component';

describe('OrangeButtonComponent', () => {
  let component: OrangeButtonComponent;
  let fixture: ComponentFixture<OrangeButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrangeButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrangeButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
