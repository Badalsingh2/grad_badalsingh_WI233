import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Login } from './login/login';
import { StudentComponent } from './student-component/student-component';
import { App } from './app';
import { Home } from './home/home';
import { authGuard } from './guards/auth-guard';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  { path: 'home', component: Home },

  {
    path:'login',
    component: Login
  },
  {
    path: 'students',
    component:StudentComponent,
    canActivate:[authGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
