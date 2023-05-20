import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = 'http://35.175.140.146:9000/users';

  constructor(private http: HttpClient) { }

  updateUserDetails(id: number, username: string, email: string): Observable<any> {
    const url = `${this.baseUrl}/${id}`; // Use backticks (`) for string interpolation
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const params = { username, email };

    return this.http.patch(url, null, { headers, params });
  }
}
