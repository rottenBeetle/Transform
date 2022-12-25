import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, Observable, retry } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

 login(username: string, password: string): Observable<any>{
    return this.http.post<any>("http://localhost:8080/api/auth/login", {
      username: username,
      password: password
    });
 }
}
