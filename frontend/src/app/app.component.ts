import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OrangeButtonComponent } from './features/outside/components/orange-button/orange-button.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, OrangeButtonComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
