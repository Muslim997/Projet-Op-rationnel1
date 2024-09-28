import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private authService: AuthService) {}

  canAccessPage(requiredRole: string): boolean {
    const userRole = this.authService.getUserRole();
    return userRole === requiredRole;
  }
}
