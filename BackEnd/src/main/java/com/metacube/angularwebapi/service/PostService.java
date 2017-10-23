package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.model.Post;


public interface PostService {
    Iterable<Post> getAllPosts();
    Post getPostByUserId(int userId);
    Post addPost(Post post);
    Post updatePost(Post post);
    Post deletePost(int postId);
}
