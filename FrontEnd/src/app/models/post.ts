import { Comment } from './comment';
import { UserPost } from './userpost';

export class Post implements UserPost {
    userId: number;
    userName: string;
    id: number;
    body: string;
    comments: Comment[];

    constructor(private userPost: UserPost) {
        this.id = userPost.id;
        this.userId = userPost.userId;
        this.userName = userPost.userName;
        this.body = userPost.body;
        this.comments = [];
    }
}
