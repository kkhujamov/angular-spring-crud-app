import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiResponse} from '../model/api-response.model';
import {Contact} from '../model/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/v1/contacts';
  }

  getAll() {
    return this.http.get<ApiResponse>(this.url);
  }

  getOne(id: number) {
    return this.http.get<ApiResponse>(`${this.url}/${id}`);
  }

  create(contact: Contact) {
    return this.http.post<ApiResponse>(this.url, contact);
  }

  update(id: number, contact: Contact) {
    return this.http.put<ApiResponse>(`${this.url}/${id}`, contact);
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
