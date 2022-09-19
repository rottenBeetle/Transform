import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private http: HttpClient;
  private baseUrl = 'http://localhost:8080/api/users';

  constructor(http: HttpClient) {
    this.http = http
  }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}`);
  }

  getAS(page: number): Observable<any>{
    return this.http.get(`http://localhost:8080/api/users/${page}/10`)
    .pipe(delay(2000));
  }
}
