import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationComponent } from './registration/registration.component';

@NgModule({
  declarations: [LoginPageComponent, RegistrationComponent],
  imports: [ MaterialModule],
  exports: [LoginPageComponent],
  providers: []
})

export class AuthModule { }
