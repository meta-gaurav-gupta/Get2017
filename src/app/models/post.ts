import { Comment } from './comment';

export class Post {
    userId: number;
    id: number;
    title: string;
    body: string;
    comment: string;
    comments: Comment[];
    isCommentsHidden: boolean;

    constructor() {
        this.comments = [];
        this.isCommentsHidden = true;
    }
}
