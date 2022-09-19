import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';
import { ToastrService } from 'ngx-toastr';
import { CompanyService } from 'src/app/services/company/company.service';



@Component({
  selector: 'app-company-request',
  templateUrl: './company-request.component.html',
  styleUrls: ['./company-request.component.scss']
})
export class CompanyRequestComponent implements OnInit {
  reqForm!: FormGroup;
  currentUser: any = {"uuid": "", "username": ""};


  constructor(  private fb: FormBuilder,
    private authService: AuthenticationService,
    private companyService: CompanyService,
    private toastr: ToastrService,) { }

  ngOnInit(): void {
    this.createForm();
    this.authService.validateToken().subscribe(
      res=>{
        this.currentUser = res.body;
        })

  }
  createForm() : void{
    this.reqForm = this.fb.group({
      name: ['', Validators.required],
      phone: ['',  Validators.required],
      address:['',  Validators.required],
      description: ['',  Validators.required]
    });
  }

  createReq(): void {
    
    let data = {
      name: this.reqForm.get('name')?.value,
      phone: this.reqForm.get('phone')?.value,
      address: this.reqForm.get('address')?.value,
      description: this.reqForm.get('description')?.value,
    }
     this.companyService.request(data).subscribe(
       res => {
         this.toastr.success("Request sent");

       }
     )

  }

}
