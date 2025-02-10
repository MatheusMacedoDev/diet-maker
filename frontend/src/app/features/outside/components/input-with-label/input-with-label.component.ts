import { Component, input } from '@angular/core';

@Component({
  selector: 'input-with-label',
  imports: [],
  templateUrl: './input-with-label.component.html',
  styleUrl: './input-with-label.component.scss'
})
export class InputWithLabelComponent {
  label = input.required<String>();
  placeholder = input.required<String>();
}
