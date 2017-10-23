package com.metacube.angularwebapi.facade.comment;

import com.metacube.angularwebapi.dto.CommentsDto;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;


public interface CommentFacade {
    
    Iterable<CommentsDto> getComments(Map<String, String> queryMap);
    Iterable<CommentsDto> getAllComments();
    CommentsDto addComments(CommentsDto comment);
}
