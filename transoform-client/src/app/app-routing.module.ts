import { Routes,RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { UserComponent } from './user/user.component';
import { TranslateFormComponent } from './translate-form/translate-form.component';
import { ProgressComponent } from './progress/progress.component';

const routes: Routes = [
  {path: 'users', component: UserComponent},
  {path: 'progress', component: ProgressComponent},
  {path: 'translater', component: TranslateFormComponent},
  {path: '', redirectTo: 'translater', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
