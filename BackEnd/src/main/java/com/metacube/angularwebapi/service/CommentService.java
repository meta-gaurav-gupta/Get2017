
package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.model.Comment;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;


public interface CommentService {
    Iterable<Comment> getAllComments();
    Iterable<Comment> getComments(Map<String, String> queryMap);
    Comment addComment(Comment comment);
}
