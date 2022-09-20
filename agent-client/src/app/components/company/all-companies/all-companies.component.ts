import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/model/Account';
import { Company } from 'src/app/model/Company';
import { Router } from '@angular/router';
import { CompanyService } from 'src/app/services/company/company.service';



@Component({
  selector: 'app-all-companies',
  templateUrl: './all-companies.component.html',
  styleUrls: ['./all-companies.component.scss']
})
export class AllCompaniesComponent implements OnInit {
   // companies: Company[] | undefined ;

  owner: Account =  {"username": "usernme", "name":"ja sam boss"};
  constructor(    private router: Router,
    private companyService: CompanyService
    ) { }
  companies!: Company[]

  ngOnInit(): void {
    this.companyService.getCompanies(0, 10).subscribe(
      res=>{
        this.companies = res.body.content as Company[];
      }
    )
  }

  openCompany(uuid: any){
    console.log("open comapny")
    console.log(uuid)
    this.router.navigate(['/company/' + uuid]);
  }

}
