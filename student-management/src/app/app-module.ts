import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { StudentComponent } from './student-component/student-component';
import { Login } from './login/login';
import { Menu } from './menu/menu';
import { Home } from './home/home';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [App, StudentComponent, Login, Menu, Home],
  imports: [BrowserModule, FormsModule,AppRoutingModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
