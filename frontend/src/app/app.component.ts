import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GoogleButtonComponent } from './features/outside/components/google-button/google-button.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GoogleButtonComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
