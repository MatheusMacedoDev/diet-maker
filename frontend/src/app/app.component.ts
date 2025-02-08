import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { InputWithLabelComponent } from './features/outside/components/input-with-label/input-with-label.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, InputWithLabelComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
