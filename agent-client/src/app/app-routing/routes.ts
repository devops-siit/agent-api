import { Routes } from '@angular/router';
import { LoginPageComponent } from '../components/auth/login-page/login-page.component';
import { RegistrationComponent } from '../components/auth/registration/registration.component';
import { CompanyRequestComponent } from '../components/company/company-request/company-request.component';
import { LoginGuard } from '../guards/login/login.service';
import { RoleGuard } from '../guards/role/role.service';


export const routes: Routes = [
    {
       path: 'login',
       component: LoginPageComponent,
       //canActivate: [LoginGuard] // putanja kojoj moze da pristupi korisnik samo ukoliko NIJE ulogovan
    },
    {
      path: 'register',
      component: RegistrationComponent,
      //canActivate: [LoginGuard] // putanja kojoj moze da pristupi korisnik samo ukoliko NIJE ulogovan
   },
   {
      path: 'companyReq',
      component: CompanyRequestComponent,
      //canActivate: [LoginGuard] // putanja kojoj moze da pristupi korisnik samo ukoliko NIJE ulogovan
   },
 
    // {
    // putanja kojoj moze da pristupi samo registrivani korisnik sa konkretnom ulogom
    //     path: 'favorites',
    //     component: FavoriteComponent,
    //     canActivate: [RoleGuard],
    //     data: {expectedRoles: 'ROLE_REGISTERED_USER'}
    // },
];
