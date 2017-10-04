import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { HomeService } from '../../services/home.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  invalid = false;
  constructor(private router: Router, private homeService: HomeService) { }

  ngOnInit() {
    if (this.homeService.getCurrentUser() !== -1) {
      this.router.navigate(['/home']);
    }
  }

  login(): void {
    this.homeService.getUserByEmail(this.email).then(response => {
      if (response === undefined) {
        this.invalid = true;
      } else {
        this.homeService.setCurrentUser(response.id);
        this.router.navigate(['/home']);
      }
    });
  }

}
