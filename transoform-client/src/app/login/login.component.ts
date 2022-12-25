import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input()
  model: any = {};
  sessionId: string = "";
  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  login(){
    this.authService.login(this.model.username, this.model.password).subscribe(res => {
      if (res){
        this.sessionId = res.sessionId;
        sessionStorage.setItem('token', this.sessionId);
        this.router.navigate(['']);
      }else{
        alert("Authentification failed.")
      }
    })
  }

}
