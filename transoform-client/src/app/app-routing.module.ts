import { Routes,RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { UserComponent } from './user/user.component';
import { ProgressComponent } from './progress/progress.component';
import { LoginComponent } from './login/login.component';
import { AuthenticationGuard } from './authentication.guard';

const routes: Routes = [
  {path: '', canActivate:[AuthenticationGuard], children: [
    {path: 'users', component: UserComponent},
    {path: 'progress', component: ProgressComponent},
    {path: 'login', component: LoginComponent}
  ]}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
