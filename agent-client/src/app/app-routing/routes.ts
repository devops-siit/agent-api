import { Routes } from '@angular/router';
import { LoginPageComponent } from '../components/auth/login-page/login-page.component';
import { RegistrationComponent } from '../components/auth/registration/registration.component';
import { AllCompaniesComponent } from '../components/company/all-companies/all-companies.component';
import { CompanyRequestComponent } from '../components/company/company-request/company-request.component';
import { CompanyRequestsComponent } from '../components/company/company-requests/company-requests.component';
import { OneCompanyComponent } from '../components/company/one-company/one-company.component';
import { CreateOfferComponent } from '../components/offer/create-offer/create-offer.component';
import { LoginGuard } from '../guards/login/login.service';
import { RoleGuard } from '../guards/role/role.service';
//import { CreateOfferComponent } from '../components/offers/create-offer/create-offer.component';



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

   {
      path: 'companies',
      component: AllCompaniesComponent,
      //canActivate: [LoginGuard] // putanja kojoj moze da pristupi korisnik samo ukoliko NIJE ulogovan
   },

   {
      path: 'company/:uuid',
      component: OneCompanyComponent,
   },
   {
      path: 'create-offer',
      component: CreateOfferComponent,
   },
   {
      path: 'company-requests',
      component: CompanyRequestsComponent,
   }
 
    // {
    // putanja kojoj moze da pristupi samo registrivani korisnik sa konkretnom ulogom
    //     path: 'favorites',
    //     component: FavoriteComponent,
    //     canActivate: [RoleGuard],
    //     data: {expectedRoles: 'ROLE_REGISTERED_USER'}
    // },
];
