import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true, // Indique que ce composant est standalone
  imports: [RouterModule], // Tu dois importer RouterModule ici pour utiliser [routerLink]
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'suivi-tutorat';
}
