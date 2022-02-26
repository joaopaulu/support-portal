import {Injectable} from '@angular/core';
import {environment} from 'environments/environment';
import {HttpClient, HttpErrorResponse, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from 'app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private host = environment.apiUrl + '/user';

  constructor(private http: HttpClient) {
  }

  public getUsers(): Observable<User[] | HttpErrorResponse> {
    return this.http.get<User[]>(`${this.host}/list`);
  }

  public addUser(formData: FormData): Observable<User | HttpErrorResponse> {
    return this.http.post<User>(`${this.host}/add`, formData);
  }

  public updateUser(formData: FormData): Observable<User | HttpErrorResponse> {
    return this.http.post<User>(`${this.host}/update`, formData);
  }

  public resetPassword(email: string): Observable<any | HttpErrorResponse> {
    return this.http.get(`${this.host}/resetpassword/${email}`);
  }

  public updateProfileImage(formData: FormData): Observable<HttpEvent<User> | HttpErrorResponse> {
    return this.http.post<User>(`${this.host}/user/updateProfileImage`, formData, {
      reportProgress: true, observe: 'events'
    });
  }

  public deleteUser(userId: number): Observable<any | HttpErrorResponse>{
    return this.http.delete<any>(`${this.host}/user/delete/${userId}`);
  }
}
