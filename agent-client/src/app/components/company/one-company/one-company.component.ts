import { Company } from 'src/app/model/Company';
import { Comment } from 'src/app/model/Comment';
import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company/company.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NewCommentComponent } from '../../comment/new-comment/new-comment.component';




@Component({
  selector: 'app-one-company',
  templateUrl: './one-company.component.html',
  styleUrls: ['./one-company.component.scss']
})
export class OneCompanyComponent implements OnInit {
  uuid: any = "";
  company?: Company;
  comments: Comment[] = [];
  avgRate?: number;



  constructor(private companyService: CompanyService,
    private route: ActivatedRoute,

    public dialog: MatDialog,
    private router: Router,
    private toastr: ToastrService

    ) { }

  ngOnInit(): void {
    this.uuid = this.route.snapshot.params.uuid;
    this.companyService.getCompanyByUuid(this.uuid).subscribe(
      res=>{
        this.company = res as Company;
        
      }
    )

    this.companyService.getCommentsByCompany(this.uuid, 0, 5).subscribe(
      res=>{
        this.comments = res.content as Comment[];
      }
    )
    this.companyService.getAvgRate(this.uuid).subscribe(
      res=>{
        this.avgRate = res.body;
        
      }, error=>{
        console.log(error)
      }
    ) 
  }

  
  sendComment(uuid: any): void {
    const dialogRef = this.dialog.open(NewCommentComponent); 
    dialogRef.componentInstance.companyUuid = this.uuid;
    dialogRef.afterClosed().subscribe(result => {
      if (result){
        console.log(`Dialog result: ${result}`);
        window.location.reload();
    }
     
   });
  console.log("comment sent")

  }

  
  rate(uuid: any, rate:any):void{
    let data = {
      rate: rate,
      companyUuid: uuid      
    }
    this.companyService.rate(data).subscribe(
      result => {
        console.log(result)
        window.location.reload()
          
      },
      error => {
          console.log(error);
          this.toastr.error('Something went wrong');
      }
  );
  }

}
