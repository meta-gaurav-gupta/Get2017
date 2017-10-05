import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from '../../services/home.service';
import { Post } from '../../models/post';
import { User } from '../../models/user';
import { Comment } from '../../models/comment';
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
  initialItem = 0;
  newPost: string;
  loadMoreData: boolean;

  constructor(private homeService: HomeService, private router: Router) { }

  ngOnInit() {
    if (this.homeService.getCurrentUser() === -1) {
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
      posts = posts.slice(this.initialItem, this.initialItem + 10);
      for (let post of posts) {
        post.isCommentsHidden = true;
      }
      this.posts = this.posts.concat(posts);
    });
  }

  getFriends(): void {
    this.homeService.getFriends().then((friends) => this.friends = friends);
  }

  getUser(): void {
    this.homeService.getUser(this.homeService.getCurrentUser()).then((user) => this.user = user);
  }

  getComments(post: Post): void {
    console.log(post.isCommentsHidden);
    post.isCommentsHidden = false;
    this.homeService.getComments(post.id).then((comments) => {
      if (post.comments === undefined) {
        post.comments = comments;
      } else {
        post.comments = post.comments.concat(comments);
      }
    });
  }

  addPost(): void {
    if (this.newPost === '' || this.newPost === undefined) {
      return;
    }
    let post: Post = {
      userId: this.homeService.getCurrentUser(),
      id: 0,
      title: '',
      body: this.newPost,
      comment: '',
      comments: [],
      isCommentsHidden: true
    };
    this.newPost = '';
    this.posts.unshift(post);
  }

  deletePost(post: Post) {
    let index = this.posts.indexOf(post);
    this.posts.splice(index, 1);
  }

  addComment(post: Post): void {
    if (post.comment === '' || post.comment === undefined) {
      return;
    }
    let comment: Comment = {
      postId: post.id,
      id: 0,
      name: '',
      email: this.user.email,
      body: post.comment,
    };
    if (post.comments === undefined) {
      post.comments = [];
    }
    post.comments.push(comment);
    post.comment = '';
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }


  doLogout(): void {
    this.homeService.setCurrentUser(-1);
    this.user = undefined;
    this.goToLogin();
  }

  goToHome(): void {
    this.router.navigate(['/home']);
  }

}
