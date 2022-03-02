import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Subscription} from 'rxjs';
import {User} from '../model/user';
import {UserService} from '../service/user.service';
import {NotificationService} from '../service/notification.service';
import {NotificationType} from '../enum/notification-type.enum';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  private titleSubject = new BehaviorSubject<string>('Users');
  public titleAction$ = this.titleSubject.asObservable();
  public users: User[];
  public refreshing: boolean;
  public selectedUser: User;
  private subscription: Subscription[] = [];

  constructor(private userService: UserService, private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.getUsers(true);
  }

  public changeTitle(title: string): void {
    this.titleSubject.next(title);
  }

  public getUsers(showNotification: boolean): void {
    this.refreshing = true;
    this.subscription.push(
      this.userService.getUsers().subscribe(
        (response: User[]) => {
          this.userService.addUsersToLocalCache(response);
          this.users = response;
          this.refreshing = false;
          if (showNotification) {
            this.sendNotification(NotificationType.SUCCESS, `${response.length} user(s) loades sucessfully.`);
          }
        },
        (errorResponse: HttpErrorResponse) => {
          this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
        }
      )
    );
  }

  public onSelectUser(selectedUser: User): void {
    this.selectedUser = selectedUser;
    document.getElementById('openUserInfo').click();
  }

  // tslint:disable-next-line:typedef
  private sendNotification(notificationType: NotificationType, message: string): void {
    if (message) {
      this.notificationService.notify(notificationType, message);
    } else {
      this.notificationService.notify(notificationType, 'An error occured. Please try again.');
    }
  }
}
