import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing/app-routing.module';


import { AppComponent } from './app.component';
import { AuthModule } from './components/auth/auth.module';
import { MaterialModule } from './components/material-module';
import { Interceptor } from './interceptors/intercept.service';
import { NavbarNonAuthComponent } from './components/navbar/navbar-non-auth/navbar-non-auth.component';
import { NavbarUserComponent } from './components/navbar/navbar-user/navbar-user.component';
import { SharedModule } from './components/shared/shared.module';
import { MatDialogModule } from '@angular/material/dialog';
import { CompanyRequestComponent } from './components/company/company-request/company-request.component';
import { AllCompaniesComponent } from './components/company/all-companies/all-companies.component';
import { OneCompanyComponent } from './components/company/one-company/one-company.component';
import { NewCommentComponent } from './components/comment/new-comment/new-comment.component';
import { CreateOfferComponent } from './components/offer/create-offer/create-offer.component';
import { CompanyRequestsComponent } from './components/company/company-requests/company-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarNonAuthComponent,
    NavbarUserComponent,
    CompanyRequestComponent,
    AllCompaniesComponent,
    OneCompanyComponent,
    NewCommentComponent,
    CreateOfferComponent,
    CompanyRequestsComponent
  ],
  imports: [
    AppRoutingModule,
    MaterialModule,
    MatDialogModule,
    AuthModule,
    SharedModule,
    BrowserModule,
    ToastrModule.forRoot(),

  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent],
})
export class AppModule { }
