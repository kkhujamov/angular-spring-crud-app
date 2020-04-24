import { Component, OnInit } from '@angular/core';
import {ContactService} from '../services/contact.service';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  constructor(private contactSvc: ContactService, private  router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form) {
    this.contactSvc.create(form).subscribe(data => {
      this.router.navigate(['contacts']);
    });
  }
}
