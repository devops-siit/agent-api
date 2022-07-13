import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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
  ) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() : void{
    this.regForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['',  Validators.required],
      email:['',  Validators.required],
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
      firstName: this.regForm.get('firstName')?.value,
      lastName: this.regForm.get('lastName')?.value,
      email: this.regForm.get('email')?.value,
      password: this.regForm.get('password')?.value,
    }
    // this.authService.signUp(data).subscribe(
    //   res => {
    //     this.toastr.success("You can now login!");

    //   }
    // )

  }
}
