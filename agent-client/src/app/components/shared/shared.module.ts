import { NgModule } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';
import { MaterialModule } from '../material-module';
import { ConfirmationComponent } from './confirmation/confirmation.component';

@NgModule({
  declarations: [ConfirmationComponent],
  imports: [ MatDialogModule, MaterialModule],
  exports: [ConfirmationComponent],
  providers: []
})

export class SharedModule { }
