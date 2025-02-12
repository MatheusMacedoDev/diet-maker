import { Component, input } from '@angular/core';

@Component({
  selector: 'splitter-with-text',
  imports: [],
  templateUrl: './splitter-with-text.component.html',
  styleUrl: './splitter-with-text.component.scss'
})
export class SplitterWithTextComponent {
  text = input.required<String>();
}
