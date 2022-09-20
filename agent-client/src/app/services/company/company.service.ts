import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
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
  
    return this.http.post(`${environment.companyReq}`,
     company, {headers: this.headers, responseType: 'json'});
}

getCompanyByUuid(uuid: any):Observable<any> {
  return this.http.get(`${environment.company}/${uuid}`,
    {headers: this.headers, responseType: 'json'}).pipe(map(res => res));
}

getCommentsByCompany(uuid: any, page: number, size: number) :Observable<any> {
  let queryParams = {};
  queryParams = {
  headers: this.headers,
      observe: 'response',
      params: new HttpParams()
          .set('page', String(page))
          .append('size', String(size)),
  };
  return this.http.get(`${environment.comment}/${uuid}`,
    {headers: this.headers, responseType: 'json'}).pipe(map(res => res));
}

getAvgRate(uuid: any): Observable<any> {
  
  return this.http.get(`${environment.rate}/${uuid}`, {headers: this.headers, responseType: 'json'}).pipe(map(res => res));
}

rate(data: any): Observable<any> {
  return this.http.post(`${environment.rate}`,
   {rate: data.rate, companyUuid: data.companyUuid}, {headers: this.headers, responseType: 'json'});
}

insertComment(data: any):Observable<any> {
  return this.http.post(`${environment.comment}`, data,
    {headers: this.headers, responseType: 'json'});
}

createOffer(offer:any): Observable<HttpResponse<any>>{

  return this.http.post<any>(`${environment.offerUrl}`, offer, {observe: 'response'})
}

getCompanies(page: number, size: number):Observable<any> {
  //pageable
  let queryParams = {};
  queryParams = {
  headers: this.headers,
      observe: 'response',
      params: new HttpParams()
          .set('page', String(page))
          .append('size', String(size)),
  };
  return this.http.get(`${environment.company}`,queryParams).pipe(map(res => res));
}
getAllCompanyRequests(page: number, size: number):Observable<any> {
  //pageable
  let queryParams = {};
  queryParams = {
  headers: this.headers,
      observe: 'response',
      params: new HttpParams()
          .set('page', String(page))
          .append('size', String(size)),
  };
  return this.http.get(`${environment.companyReq}`,queryParams).pipe(map(res => res));
}
approveCompanyRequest(uuid: any): Observable<HttpResponse<any>>{

  return this.http.put<any>(`${environment.companyReq}/approve/${uuid}`, {observe: 'response'})
}
rejectCompanyRequest(uuid: any): Observable<HttpResponse<any>>{

  return this.http.put<any>(`${environment.companyReq}/reject/${uuid}`, {observe: 'response'})
}
getPendingRequests(page: number, size: number):Observable<any> {
  //pageable
  let queryParams = {};
  queryParams = {
  headers: this.headers,
      observe: 'response',
      params: new HttpParams()
          .set('page', String(page))
          .append('size', String(size)),
  };
  return this.http.get(`${environment.companyReq}/pending`,queryParams).pipe(map(res => res));
}
}
