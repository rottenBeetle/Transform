import { AfterViewInit, Component, ElementRef, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Subscription } from 'rxjs';
import { User } from '../user';
import { UserService } from '../service/user.service';
import { NgxSpinnerModule, NgxSpinnerService } from "ngx-spinner";
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit, AfterViewInit {
  @ViewChildren('theLastList',{read: ElementRef})
  theLastList?: QueryList<ElementRef>
  private userService: UserService;
  users: User[] = [];
  alSub?: Subscription;
  totalPages: number = 0;
  currentPage: number = 0;
  observer: any;

  constructor(userService: UserService, private spinner: NgxSpinnerService) {
    this.userService = userService;
  }
  ngAfterViewInit(): void {
    this.theLastList?.changes.subscribe((data) => {
      if (data.last) this.observer.observe(data.last.nativeElement);
    })
  }

  ngOnInit(): void {
    this.getPaginatedUsers();
    this.intersectionObserver();
  }

  getPaginatedUsers() {
    this.spinner.show();
    this.alSub = this.userService.getAS(this.currentPage).subscribe((data) => {
      this.spinner.hide();
      this.users = data;
      this.totalPages = data.totalPages ;
      data.forEach((element: User) => {
        this.users.push(element)
      });
    })
  }

  getUsers(): User[]{
    this.userService.getUsers().subscribe((data: User[]) =>{
      this.users = data;
    });
    return this.users;
  }

  intersectionObserver(){
    let options = {
      root: null,
      rootMargin: '0px',
      threshold:0.5,
    };
    this.observer = new IntersectionObserver((entries) => {
      if (entries[0].isIntersecting){
        if(this.currentPage < this.totalPages) {
          this.currentPage++;
          this.getPaginatedUsers();
        }
      }
    },options)
  }
}
