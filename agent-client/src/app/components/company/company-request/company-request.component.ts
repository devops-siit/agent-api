import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-company-request',
  templateUrl: './company-request.component.html',
  styleUrls: ['./company-request.component.scss']
})
export class CompanyRequestComponent implements OnInit {
  reqForm!: FormGroup;


  constructor(  private fb: FormBuilder,
    private authService: AuthenticationService,
    private toastr: ToastrService,) { }

  ngOnInit(): void {
    this.createForm();

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
    // this.companyService.request(data).subscribe(
    //   res => {
    //     this.toastr.success("You can now login!");

    //   }
    // )

  }

}
