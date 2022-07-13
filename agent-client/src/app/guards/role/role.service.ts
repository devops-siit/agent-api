import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, CanActivate } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';

@Injectable({
    providedIn: 'root'
})
export class RoleGuard implements CanActivate {
    constructor(
        public auth: AuthenticationService,
        public router: Router
    ) { }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoles: string = route.data.expectedRoles;

        const token = localStorage.getItem('user') || '';
        const jwt: JwtHelperService = new JwtHelperService();
        try{
            const accessToken = JSON.parse(token);
            if (!token) {
                this.router.navigate(['/login']);
                return false;
            }
            const roles: string[] = expectedRoles.split('|', 2);
            const info = jwt.decodeToken(token);
    
            if (roles.indexOf(info.role) === -1) {
                this.router.navigate(['/login']);
                return false;
            }
        }
        catch {
            this.router.navigate(['/login']);
            return false;
        }
        
        
        return true;
    }
}
