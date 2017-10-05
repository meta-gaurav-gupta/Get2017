import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Post } from '../models/post';
import { User } from '../models/user';
import { Comment } from '../models/comment';

@Injectable()
export class HomeService {
  private postUrl = 'https://jsonplaceholder.typicode.com/posts/';
  private userUrl = 'https://jsonplaceholder.typicode.com/users/';
  private commentUrl = 'https://jsonplaceholder.typicode.com/comments/';
  private currentUser: number;
  constructor(private http: Http) { }

  getPosts(): Promise<Post[]> {
    return this.http.get(this.postUrl)
    .toPromise()
    .then((response) => response.json() as Post[])
    .catch(this.handleError);
  }
  getPostsOfUser(userId: number): Promise<Post[]> {
    if (userId === undefined) { return undefined; }
    return this.http.get(this.postUrl + '?userId=' + userId)
               .toPromise()
               .then((response) => response.json() as Post[])
               .catch(this.handleError);
  }

  getFriends(): Promise<User[]> {
    return this.http.get(this.userUrl).toPromise().then((response) => response.json() as User[]).catch(this.handleError);
  }

  getUser(id: number): Promise<User> {
    if (id === undefined) { return undefined; }
    return this.http.get(this.userUrl + id).toPromise().then((response) => response.json()).catch(this.handleError);
  }

  getComments(postId: number): Promise<Comment[]> {
    if (postId === undefined) { return undefined; }
    return this.http.get(this.commentUrl + '?postId=' + postId)
    .toPromise().then((response) => response.json() as Comment[]).catch(this.handleError);
  }

  getUserByEmail(email: string): Promise<User> {
    if (email === undefined) { return undefined; }
    return this.http.get(this.userUrl + '?email=' + email).toPromise().then((response) => {
      if (response.json().length > 0) {
        return response.json()[0] as User;
      } else {
        return undefined;
      }
    }).catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  setCurrentUser(userId: number): void {
    localStorage.setItem('userId', JSON.stringify(userId));
  }

  getCurrentUser(): number {
    let currentUser = JSON.parse(localStorage.getItem('userId'));
    return currentUser;
  }


}
