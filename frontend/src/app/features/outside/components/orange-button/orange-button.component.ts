import { Component, input } from '@angular/core';

@Component({
  selector: 'orange-button',
  imports: [],
  templateUrl: './orange-button.component.html',
  styleUrl: './orange-button.component.scss'
})
export class OrangeButtonComponent {
  text = input.required<String>();
}
