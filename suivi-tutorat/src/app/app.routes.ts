import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AssignmentsComponent } from './assignments/assignments.component';
import { SessionsComponent } from './sessions/sessions.component';
import { ReportsComponent } from './reports/reports.component';
import { CalendarComponent } from './calendar/calendar.component';
import { UsersComponent } from './users/users.component';

export const routes: Routes = [
  { path: '', component: LoginComponent }, // Page d'authentification
  { path: 'dashboard', component: DashboardComponent }, // Tableau de bord
  { path: 'assignments', component: AssignmentsComponent }, // Gestion des affectations
  { path: 'sessions', component: SessionsComponent }, // Suivi des séances
  { path: 'reports', component: ReportsComponent }, // Rapports et statistiques
  { path: 'calendar', component: CalendarComponent }, // Calendrier des séances
  { path: 'users', component: UsersComponent }, // Gestion des utilisateurs
  { path: '**', redirectTo: '' } // Redirection par défaut
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
