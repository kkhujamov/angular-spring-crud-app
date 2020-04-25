import { Component, OnInit } from '@angular/core';
import {ContactService} from '../services/contact.service';
import {ApiResponse} from '../model/api-response.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {
  contacts: object = [];

  constructor(private contactSvc: ContactService, private router: Router) {
  }

  ngOnInit(): void {
    this.reloadData();
  }

  delete(id: number) {
    this.contactSvc.delete(id).subscribe(data => {
      this.reloadData();
    });
  }

  update(id: number) {
    this.router.navigate(['update', id]);
  }

  reloadData() {
    this.contactSvc.getAll().subscribe((res: ApiResponse) => {
      const {data} = res;
      this.contacts = data;
    });
  }
}




