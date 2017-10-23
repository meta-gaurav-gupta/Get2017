package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.post.PostDao;
import com.metacube.angularwebapi.model.Post;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional
public class DefaultPostService implements PostService{
    
    @Resource(name = "hibernatePostDao")
    private PostDao postDao;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Iterable<Post> getAllPosts() {
        return postDao.findAll();
    }

    @Override
    public Post getPostByUserId(int userId) {
        return postDao.findOne(userId);
    }

    @Override
    public Post addPost(Post post) {
        System.out.println(post.toString());
        return postDao.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return postDao.update(post);
    }

    @Override
    public Post deletePost(int postId) {
        System.out.println(postId);
        return postDao.delete(postId);
    }
}
