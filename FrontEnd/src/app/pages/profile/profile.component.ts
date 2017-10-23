import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HomeService } from '../../services/home.service';

import { User } from '../../models/user';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  constructor(private homeService: HomeService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap
    .switchMap((params: ParamMap) => this.homeService.getUser(+params.get('id')))
    .subscribe(user => this.user = user);
  }

}
