import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Post } from '../pages/home/post';
import { User } from '../pages/home/user';
@Injectable()
export class HomeService {
  private postUrl = 'https://jsonplaceholder.typicode.com/posts/';
  private userUrl = 'https://jsonplaceholder.typicode.com/users/';
  private currentUser: number;
  constructor(private http: Http) { }

  getPosts(): Promise<Post[]> {
    return this.http.get(this.postUrl)
    .toPromise()
    .then((response) => response.json() as Post[])
    .catch(this.handleError);
  }
  getPostsOfUser(userId: number): Promise<Post[]> {
    return this.http.get(this.postUrl + '?userId=' + userId)
               .toPromise()
               .then((response) => response.json() as Post[])
               .catch(this.handleError);
  }

  getFriends(): Promise<User[]> {
    return this.http.get(this.userUrl).toPromise().then((response) => response.json()).catch(this.handleError);
  }

  getUser(id: number): Promise<User> {
    return this.http.get(this.userUrl + id).toPromise().then((response) => response.json() as User).catch(this.handleError);
  }

  getUserByEmail(email: string): Promise<User> {
    return this.http.get(this.userUrl + '?email=' + email).toPromise().then((response) => {
      console.log(response.json().length);
      if (response.json().length > 0) {
        console.log('>0');
        return response.json()[0];
      } else {
        console.log('<0');
        return undefined;
      }
    }).catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  setCurrentUser(userId: number): void {
    this.currentUser = userId;
  }

  getCurrentUser(): number {
    return this.currentUser;
  }

}
