import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Account } from 'src/app/model/Account';
import { CompanyRequest } from 'src/app/model/CompanyReques';
import { CompanyService } from 'src/app/services/company/company.service';
import { CompanyRequestComponent } from '../company-request/company-request.component';

@Component({
  selector: 'app-company-requests',
  templateUrl: './company-requests.component.html',
  styleUrls: ['./company-requests.component.scss']
})
export class CompanyRequestsComponent implements OnInit {

  
  requests: CompanyRequest[] = []
  
  constructor(
    private router: Router,
    private fb: FormBuilder,
    public dialog: MatDialog,
    private toastr: ToastrService,
    private companyService: CompanyService,
  ) { }

  
  ngOnInit(): void {    
    this.companyService.getPendingRequests(0, 10).subscribe(
      res=>
      {
        this.requests = res.body.content as CompanyRequest[];
      }
    )
  }

  accept(uuid: any): void {
    this.companyService.approveCompanyRequest(uuid).subscribe(
      res=>{
        this.toastr.success("Company created");
        window.location.reload();
      }
    )
  }

  decline(uuid: any): void {
    this.companyService.rejectCompanyRequest(uuid).subscribe(
      res=>{
        this.toastr.success("Company rejected");
        window.location.reload();

      }
    )
  }

}
