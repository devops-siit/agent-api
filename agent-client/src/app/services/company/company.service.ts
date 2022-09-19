import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { User } from '../../model/User';
import { environment } from 'src/environments/environment';
import { query } from '@angular/animations';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient
    ) { }

  request(company: any): Observable<any> {
  
    return this.http.post(`${environment.agentUrl}/${environment.companyReq}`,
     company, {headers: this.headers, responseType: 'json'});
}
}
