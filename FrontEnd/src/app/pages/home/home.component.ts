import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from '../../services/home.service';
import { Post } from '../../models/post';
import { UserPost } from '../../models/userpost';
import { User } from '../../models/user';
import { NewUser } from '../../models/newuser';
import { Comment } from '../../models/comment';
import { FilterNamePipe } from '../../filter.names.pipe';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/switchMap';

// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  posts: Post[] = [];
  friends: NewUser[] = [];
  user: NewUser;
  initialItem = 0;
  newPost: string;
  loadMoreData: boolean;
  filteredUsers: Observable<User[]>;
  searchTerms = new Subject<string>();
  constructor(private homeService: HomeService, private router: Router) { }

  ngOnInit() {
    if (this.homeService.getCurrentUser() === null) {
      this.goToLogin();
    }
    this.getSearchResults();
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
      this.posts = this.posts.concat(posts);
    });
  }

  getFriends(): void {
    this.homeService.getFriends().then((friends) => this.friends = friends);
  }

  getUser(): void {
    this.homeService.getUser(this.homeService.getCurrentUser().id).then((user) => this.user = user);
  }

  searchUser(term: string) {
    console.log(term);
    this.searchTerms.next(term);
  }

  getSearchResults(): void {
    this.filteredUsers = this.searchTerms
    .debounceTime(300)
    .distinctUntilChanged()
    .switchMap(term => term
      ? this.homeService.searchUser(term)
      : Observable.of<User[]>([]))
      .catch(error => {
        console.log(error);
        return Observable.of<User[]>([]);
      });
  }

  getComments(post: Post): void {
    console.log(post);
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
    let post2: UserPost = {
      userId: this.user.id,
      userName: this.user.name,
      id: 0,
      body: this.newPost
    };
    this.newPost = '';
    let post1 = new Post(post2);
    this.homeService.addPost(post2);
    this.posts.unshift(post1);
  }

  editPost(post: Post) {
    if (post.body === '' || post.body === undefined) {
      return;
    }
    let post2: UserPost = {
      userId: post.userId,
      userName: post.userName,
      id: post.id,
      body: post.body
    };
    console.log(post);
    this.homeService.updatePost(post2);
    this.posts.unshift(post);
  }

  deletePost(post: Post) {
    this.homeService.deletePost(post.id).then((response) => {
      let index = this.posts.indexOf(post);
      this.posts.splice(index, 1);
    });
  }

  addComment(newComment: string, post: Post): void {
    if (newComment === '' || newComment === undefined) {
      return;
    }
    console.log(this.user.name);
    let comment: Comment = {
      postId: post.id,
      id: 0,
      userId: this.user.id,
      username: this.user.name,
      body: newComment,
    };
    if (post.comments === undefined) {
      post.comments = [];
    }
    this.homeService.addComment(comment);
    post.comments.push(comment);
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }


  doLogout(): void {
    this.homeService.setCurrentUser(null);
    this.user = undefined;
    this.goToLogin();
  }

  goToHome(): void {
    if (this.router.url === '/home') {
      location.reload();
    } else {
      this.router.navigate(['/home']);
    }
  }

  focusInput() {
    document.getElementById('editpost').focus();
  }

}
