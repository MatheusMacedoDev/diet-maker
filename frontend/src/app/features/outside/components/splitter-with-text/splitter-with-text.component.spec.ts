import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SplitterWithTextComponent } from './splitter-with-text.component';

describe('SplitterWithTextComponent', () => {
  let component: SplitterWithTextComponent;
  let fixture: ComponentFixture<SplitterWithTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SplitterWithTextComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SplitterWithTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
