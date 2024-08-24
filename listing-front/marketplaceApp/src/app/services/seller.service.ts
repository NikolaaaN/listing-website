import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SellerService {
  private apiUrl = 'http://localhost:8080/seller';

  constructor(private http: HttpClient) {}

  getSellerInfo(id: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('id', id);
    return this.http.get<any>(this.apiUrl, { params });
  }
}
