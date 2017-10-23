import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Post } from '../models/post';
import { UserPost } from '../models/userpost';
import { User } from '../models/user';

import { NewUser } from '../models/newuser';
import { Comment } from '../models/comment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class HomeService {
  private postUrl = 'http://localhost:8080/AngularWebApi/api/posts/';
  private userUrl = 'https://jsonplaceholder.typicode.com/users/';
  private newUserUrl = 'http://localhost:8080/AngularWebApi/api/users/';
  private commentUrl = 'http://localhost:8080/AngularWebApi/api/comments/';
  private currentUser: number;
  constructor(private http: Http) { }

  addPost(post: UserPost): Promise<UserPost> {
    let header = new Headers({
      'Content-Type': 'application/json'
    });
    return this.http.post(this.postUrl, JSON.stringify(post), { headers: header })
    .toPromise()
    .then((response) => response.json() as UserPost)
    .catch(this.handleError);
  }

  updatePost(post: UserPost): Promise<UserPost> {
    let header = new Headers({
      'Content-Type': 'application/json'
    });
    return this.http.put(this.postUrl, JSON.stringify(post), { headers: header })
    .toPromise()
    .then((response) => response.json() as UserPost)
    .catch(this.handleError);
  }

  deletePost(postId: number): Promise<Post> {
    return this.http.delete(this.postUrl + postId, { body: postId })
    .toPromise()
    .then((response) => (response.json() as Post))
    .catch(this.handleError);
  }

  getPosts(): Promise<Post[]> {
    return this.http.get(this.postUrl)
    .toPromise()
    .then((response) => (response.json() as Post[]).reverse())
    .catch(this.handleError);
  }

  getPostsOfUser(userId: number): Promise<Post[]> {
    if (userId === undefined) { return undefined; }
    return this.http.get(this.postUrl + userId)
               .toPromise()
               .then((response) => response.json() as Post[])
               .catch(this.handleError);
  }

  getFriends(): Promise<User[]> {
    return this.http.get(this.newUserUrl).toPromise().then((response) => response.json() as NewUser[]).catch(this.handleError);
  }

  getUser(id: number): Promise<User> {
    if (id === undefined) { return undefined; }
    return this.http.get(this.newUserUrl + id).toPromise().then(response => response.json() as NewUser)
      .catch(this.handleError);
  }

  searchUser(query: string): Observable<User[]> {
    return this.http.get(this.newUserUrl + '?search=' + query).map(response => response.json() as User[]);
  }

  addComment(comment: Comment): Promise<Comment> {
    let header = new Headers({
      'Content-Type': 'application/json'
    });
    return this.http.post(this.commentUrl, JSON.stringify(comment), { headers: header })
    .toPromise()
    .then((response) => {
      console.log(response.json());
    })
    .catch(this.handleError);
  }

  getComments(postId: number): Promise<Comment[]> {
    if (postId === undefined) { return undefined; }
    let requestUrl = this.commentUrl + '?postId=' + postId;
    return this.http.get(requestUrl)
    .toPromise().then((response) => response.json() as Comment[]).catch(this.handleError);
  }

  getUserByEmail(email: string): Promise<User> {
    if (email === undefined) { return undefined; }
    return this.http.get(this.newUserUrl + '?email=' + email).toPromise().then((response) => {
      if (response.json().length > 0) {
        return response.json()[0] as User;
      } else {
        return undefined;
      }
    }).catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error._body); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  setCurrentUser(user: User): void {
    localStorage.setItem('user', JSON.stringify(user));
  }

  getCurrentUser(): User {
    let currentUser = JSON.parse(localStorage.getItem('user'));
    return currentUser;
  }

}
