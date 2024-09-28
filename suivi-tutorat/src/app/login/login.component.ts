import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Import de CommonModule pour utiliser *ngIf

@Component({
  selector: 'app-login',
  standalone: true,  // Composant standalone
  imports: [FormsModule, CommonModule],  // Ajout de CommonModule ici
  templateUrl: './login.component.html'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(private router: Router) { }

  login() {
    if (this.email === 'admin@gmail.com' && this.password === 'Passer123') {
      this.router.navigate(['/dashboard']);
    } else {
      this.errorMessage = 'Invalid email or password';
    }
  }
}
