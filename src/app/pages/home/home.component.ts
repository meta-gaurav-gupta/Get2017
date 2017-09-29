import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { HomeService } from '../../services/home.service';
import { Post } from './post';
import { User } from './user';
import { FilterNamePipe } from '../../filter.names.pipe';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posts: Post[] = [];
  friends: User[] = [];
  user: User;
  placeholderText: string;
  initialItem = 0;
  newPost: string;
  loadMoreData: boolean;
  constructor(private homeService: HomeService, private router: Router , private route: ActivatedRoute) { }

  ngOnInit() {
    if (this.homeService.getCurrentUser() === undefined) {
      this.goToLogin();
    }
    this.getUser();
    this.getPosts();
    this.getFriends();
  }

  profile(id: number): void {
    this.router.navigate(['/profile', id]);
  }

  loadMore(): void {
    this.initialItem += 10;
    this.getPosts();
  }

  getPosts(): void {
    this.homeService.getPosts()
    .then((posts) => {
      this.posts = this.posts.concat(posts.slice(this.initialItem, this.initialItem + 10));
    });
  }

  getFriends(): void {
    this.homeService.getFriends().then((friends) => this.friends = friends);
  }

  getUser(): void {
    this.homeService.getUser(this.homeService.getCurrentUser()).then((user) => this.user = user);
  }


  addPost(): void {
    const post: Post = {
      userId: this.homeService.getCurrentUser(),
      id: 0,
      title: '',
      body: this.newPost
    };
    this.newPost = '';
    this.posts.unshift(post);
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }
}
