package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.comment.CommentDao;
import com.metacube.angularwebapi.model.Comment;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;


public class DefaultCommentService implements CommentService{
    private CommentDao commentDao;

    public DefaultCommentService(CommentDao commentDao) {
            this.commentDao = commentDao;
    }

    @Override
    public Iterable<Comment> getAllComments() {
        return commentDao.findAll();
    }

    @Override
    public Iterable<Comment> getComments(MultivaluedMap<String, String> queryMap) {
        if(queryMap.isEmpty()) { return getAllComments(); }
        return commentDao.findAll(queryMap);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }
}
