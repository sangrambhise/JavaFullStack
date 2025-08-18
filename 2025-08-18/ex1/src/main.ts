import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
// import { AppComponent } from './app/app.component';
// Ex3
// import { SecondcompComponent } from './app/secondcomp/secondcomp.component';
// Ex4
// import { Ex4Component } from './app/login/login.component';
// Ex6
import { Ex6Component } from './app/ex6/ex6.component';
bootstrapApplication(Ex6Component, appConfig)
  .catch((err) => console.error(err));
