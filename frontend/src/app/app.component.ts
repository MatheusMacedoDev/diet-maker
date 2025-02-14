import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { InsideHeaderComponent } from './features/inside/components/inside-header/inside-header.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, InsideHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
