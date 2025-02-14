import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'inside-header',
  imports: [FontAwesomeModule, NgOptimizedImage],
  templateUrl: './inside-header.component.html',
  styleUrl: './inside-header.component.scss'
})
export class InsideHeaderComponent {
  faUser = faUser;
  nutflyImageUri = 'nutfly-logo.png';
}
