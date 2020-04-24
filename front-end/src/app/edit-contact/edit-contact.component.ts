import {Component, OnInit, ViewChild} from '@angular/core';
import {ContactService} from '../services/contact.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Contact} from '../model/contact.model';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {

  id: number;
  contact: Contact;
  constructor(private service: ContactService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.contact = new Contact();
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.service.getOne(this.id).subscribe(res => {
      const { data } = res;
      this.contact = data;
    });
  }

  onSubmit(value: Contact) {
    this.service.update(this.id, value).subscribe(res => {
      this.router.navigate(['/contacts']);
    });
  }
}
