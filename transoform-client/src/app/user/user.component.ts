import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  private userService: UserService;
  users: User[] = [];

  constructor(userService: UserService) {
    this.userService = userService;
  }

  ngOnInit(): void {
    this.userService.getUsers().subscribe((data: User[]) =>{
      this.users = data;
    });
  }

  getUsers(): User[]{
    return this.users;
  }
}
