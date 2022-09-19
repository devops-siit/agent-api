import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  regForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private toastr: ToastrService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.createForm();
  }

 
  createForm() : void{
    this.regForm = this.fb.group({
      name: ['', Validators.required],
      phone: ['',  Validators.required],
      gender:['',  Validators.required],
      email:['',  Validators.required],
      username:['',  Validators.required],
      password: ['',  Validators.required],
      repeatedPass: ['',  Validators.required]
    });
  }

  register(): void {
    if(this.regForm.get('password')?.value != this.regForm.get('repeatedPass')?.value){
      this.toastr.error("Password missmatch")
      return;
    }
    let data = {
      name: this.regForm.get('name')?.value,
      phone: this.regForm.get('phone')?.value,
      gender: this.regForm.get('gender')?.value,
      email: this.regForm.get('email')?.value,
      username: this.regForm.get('username')?.value,
      password: this.regForm.get('password')?.value,
    }
    console.log("Dataa")
    console.log(data)
     this.authService.register(data).subscribe(
       res => {
         this.toastr.success("You can now login!");
         this.router.navigate(['/login']);
       },
            error => {
                console.log(error);
                console.log(error.status);
                console.log(error.statusText);
                console.log(error.localizedErrorMessage);

                if (error.status = 409) {
                  this.toastr.error("Account already exists");
                } else {
                  this.toastr.error("Something went wrong");
                }

                
            }
     )

  }
}
