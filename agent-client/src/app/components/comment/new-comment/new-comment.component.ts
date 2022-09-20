import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company/company.service';


@Component({
  selector: 'app-new-comment',
  templateUrl: './new-comment.component.html',
  styleUrls: ['./new-comment.component.scss']
})
export class NewCommentComponent implements OnInit {

  companyUuid!: any;
  commentForm!: FormGroup;
  user: any = {};
 // posts: any = [];
  //following = true;
  //privateAccount = true;
  result: any;

  constructor( 
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router,
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<NewCommentComponent>,
    private companyService: CompanyService,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    this.createForm();

    }

  createForm(): void {
    this.commentForm = this.fb.group({
      commentText: ['']
    });
  }

  sendComment(): void {
    console.log(this.companyUuid);
    //send comment

    this.companyService.insertComment({"text": this.commentForm.value.commentText, "companyUuid": this.companyUuid}).subscribe(
      res=>{
        this.toastr.success("Comment added");
      },
      error => {
          console.log(error);
          this.toastr.error("Cannot add comment");
      }
    )
    this.dialogRef.close(false);

  }

  cancel():void {
    this.dialogRef.close(false);
  }

}
