// src/app/auth/auth.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private isAuthenticated = false;
  private userRole: string | null = null;

  constructor() {}

  // Simule le processus de connexion
  login(username: string, password: string): boolean {
    // Implémentez la logique d'authentification ici (par exemple vérifier les identifiants)
    if (username === 'tuteur' && password === '1234') {
      this.isAuthenticated = true;
      this.userRole = 'tuteur';
      return true;
    } else if (username === 'tracking' && password === '1234') {
      this.isAuthenticated = true;
      this.userRole = 'equipeTracking';
      return true;
    }

    return false;
  }

  logout() {
    this.isAuthenticated = false;
    this.userRole = null;
  }

  isTuteur(): boolean {
    return this.userRole === 'tuteur';
  }

  isEquipeTracking(): boolean {
    return this.userRole === 'equipeTracking';
  }

  getUserRole(): string | null {
    return this.userRole;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }
}
