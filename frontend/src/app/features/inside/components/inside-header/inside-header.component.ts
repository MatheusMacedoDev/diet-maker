import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser, faBars } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'inside-header',
  imports: [FontAwesomeModule, NgOptimizedImage],
  templateUrl: './inside-header.component.html',
  styleUrl: './inside-header.component.scss'
})
export class InsideHeaderComponent {
  faUser = faUser;
  faBars = faBars;

  nutflyImageUri = 'nutfly-logo.png';
}
