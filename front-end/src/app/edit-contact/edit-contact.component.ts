import {Component, OnInit, ViewChild} from '@angular/core';
import {ContactService} from '../services/contact.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Contact} from '../model/contact.model';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {

  id: number;
  contact: Contact;
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
  constructor(private service: ContactService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.service.getOne(this.id).subscribe(res => {
      const { data } = res;
      this.contact = new Contact();
      this.contact = (data as Contact);
      this.form.setValue({
        name: this.contact.name,
        phoneNumber: this.contact.phoneNumber
      });
    });
  }

  get name() {
    return this.form.get('name');
  }

  get number() {
    return this.form.get('phoneNumber');
  }

  onSubmit() {
    this.service.update(this.id, this.form.value).subscribe(res => {
      this.router.navigate(['/contacts']);
    });
  }
}
