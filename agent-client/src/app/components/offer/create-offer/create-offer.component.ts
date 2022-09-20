import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Account } from 'src/app/model/Account';


@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.scss']
})
export class CreateOfferComponent implements OnInit {

  regForm!: FormGroup;
  owner: Account =  {"username": "usernme", "name":"ja sam boss"};//kasnije brisi ovo kad dobavis kompanijesa back-a
  //TO DO: da se dobave kompanije
  //lista.filter(x=>x.owner.uuid != ulogovaniUUid)
  companies = [{"uuid": 1, "name": "Ime kompanije", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558", "description": "Ovo je najjaca kompanija ikada", "owner": this.owner}, 
   {"uuid":2, "name": "Ime kompanije2", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558","description": "Ovo je najjaca kompanija ikada", "owner": this.owner}, 
   {"uuid": 3, "name": "Ime kompanije3", "address": "Bulevar Oslobodjenja 50, Novi Sad","phone": "+381 254 558", "description": "Ovo je najjaca kompanija ikada", "owner": this.owner},
   {"uuid": 4, "name": "Ime kompanije4", "address": "Bulevar Oslobodjenja 50, Novi Sad", "phone": "+381 254 558","description": "Ovo je najjaca kompanija ikada", "owner": this.owner}]


  constructor(
    private fb: FormBuilder,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    this.createForm();

  }

  createForm() : void{
    this.regForm = this.fb.group({
      position: ['', Validators.required],
      description: ['',  Validators.required],
      prerequisites:['',  Validators.required]
      
    });
  }

  create(): void {
    
    let data = {
      position: this.regForm.get('position')?.value,
      description: this.regForm.get('description')?.value,
      prerequisites: this.regForm.get('prerequisites')?.value,
      companyUuid: this.regForm.get('company')?.value,
    }
    console.log(data)
    //

  }

}
