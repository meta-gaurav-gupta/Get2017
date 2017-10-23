package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.comment.CommentDao;
import com.metacube.angularwebapi.model.Comment;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
@Transactional
public class DefaultCommentService implements CommentService{
    
    @Resource(name = "hibernateCommentDao")
    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Iterable<Comment> getAllComments() {
        return commentDao.findAll();
    }

    @Override
    public Iterable<Comment> getComments(Map<String, String> queryMap) {
        if(queryMap.isEmpty()) { return getAllComments(); }
        return commentDao.findAll(queryMap);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }
}
