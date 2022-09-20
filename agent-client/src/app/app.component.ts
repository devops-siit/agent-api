import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Github';
  public logged!: boolean;
  constructor(private router: Router) {}

  checkRole(): void {
    const item = localStorage.getItem('user');

    if (item) {
        this.logged = true;
        return;
    }
    else{
      this.logged = false;
      return;
    }
  }
}
