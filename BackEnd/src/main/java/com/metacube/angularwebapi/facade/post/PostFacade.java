package com.metacube.angularwebapi.facade.post;

import com.metacube.angularwebapi.dto.PostsDto;

public interface PostFacade {
    
    Iterable<PostsDto> getAllPosts();
    PostsDto getPostByUserId(int userId);
    PostsDto addPost(PostsDto post);
    PostsDto updatePost(PostsDto post);
    PostsDto deletePost(int postId);
}
