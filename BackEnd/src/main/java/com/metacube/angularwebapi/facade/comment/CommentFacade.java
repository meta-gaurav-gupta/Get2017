package com.metacube.angularwebapi.facade.comment;

import com.metacube.angularwebapi.dto.CommentsDto;
import javax.ws.rs.core.MultivaluedMap;


public interface CommentFacade {
    
    Iterable<CommentsDto> getComments(MultivaluedMap<String, String> queryMap);
    Iterable<CommentsDto> getAllComments();
    CommentsDto addComments(CommentsDto comment);
}
