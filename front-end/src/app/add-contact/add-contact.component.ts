import { Component, OnInit } from '@angular/core';
import {ContactService} from '../services/contact.service';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {
  form = new FormGroup({
    name: new FormControl(
      '',
      [Validators.required, Validators.minLength(3), Validators.maxLength(15)],
      []),
    phoneNumber: new FormControl(
      '',
      [Validators.required, Validators.minLength(10), Validators.maxLength(15)],
      []
    )
  });

  constructor(private contactSvc: ContactService, private  router: Router) { }

  ngOnInit(): void {
  }

  get name() {
    return this.form.get('name');
  }

  get number() {
    return this.form.get('phoneNumber');
  }

  onSubmit() {
    this.contactSvc.create(this.form.value).subscribe(data => {
      this.router.navigate(['contacts']);
    });
  }
}
