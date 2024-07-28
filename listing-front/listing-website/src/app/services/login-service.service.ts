import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { User } from '../models/user.model';
import { catchError, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginServiceService {
  private url = 'http://localhost:8080/user/login';

  constructor(private http: HttpClient) {}

  login(user: User) {
    return this.http.post<User>(this.url, user).pipe(
      tap((response: any) => {
        sessionStorage.setItem('username', response.username);
      }),
      catchError(this.placeholder)
    );
  }
  placeholder(error: HttpErrorResponse) {
    return throwError(() => {
      console.log(error);
    });
  }
}
