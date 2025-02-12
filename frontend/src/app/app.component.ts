import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SplitterWithTextComponent } from './features/outside/components/splitter-with-text/splitter-with-text.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SplitterWithTextComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
