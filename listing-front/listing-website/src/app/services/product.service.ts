import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) {}

  submitProduct(formData: FormData): Observable<any> {
    return this.http.post<any>(this.apiUrl, formData);
  }

  getProducts(page: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('page', page.toString());
    return this.http.get<any>(this.apiUrl, { params });
  }
}
