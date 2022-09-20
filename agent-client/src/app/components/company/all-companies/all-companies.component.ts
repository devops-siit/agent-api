import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/model/Account';
import { Company } from 'src/app/model/Company';
import { Router } from '@angular/router';



@Component({
  selector: 'app-all-companies',
  templateUrl: './all-companies.component.html',
  styleUrls: ['./all-companies.component.scss']
})
export class AllCompaniesComponent implements OnInit {
   // companies: Company[] | undefined ;

  owner: Account =  {"username": "usernme", "name":"ja sam boss"};
  constructor(    private router: Router,
    ) { }
  companies = [{"uuid": 1, "name": "Ime kompanije", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558", "description": "Ovo je najjaca kompanija ikada", "owner": this.owner}, 
   {"uuid":2, "name": "Ime kompanije", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558","description": "Ovo je najjaca kompanija ikada", "owner": this.owner}, 
   {"uuid": 3, "name": "Ime kompanije", "address": "Bulevar Oslobodjenja 50, Novi Sad","phone": "+381 254 558", "description": "Ovo je najjaca kompanija ikada", "owner": this.owner},
   {"uuid": 4, "name": "Ime kompanije", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558","description": "Ovo je najjaca kompanija ikada", "owner": this.owner}]


  ngOnInit(): void {
  }

  openCompany(uuid: any){
    console.log("open comapny")
    console.log(uuid)
    this.router.navigate(['/company/' + uuid]);
  }

}
