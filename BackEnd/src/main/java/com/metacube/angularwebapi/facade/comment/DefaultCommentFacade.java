package com.metacube.angularwebapi.facade.comment;

import com.metacube.angularwebapi.dto.CommentsDto;
import com.metacube.angularwebapi.model.Comment;
import com.metacube.angularwebapi.service.CommentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("commentFacade")
public class DefaultCommentFacade implements CommentFacade {
    
    @Autowired
    private CommentService commentService;
    
    public DefaultCommentFacade() {
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    
    public DefaultCommentFacade(CommentService commentService) {
            this.commentService = commentService;
    }

    
    
    protected Comment dtoToModel(CommentsDto commentsDto) {
            if (commentsDto == null) {
                    return null;
            }
            Comment comment = new Comment();
            comment.setId(commentsDto.getId());
            comment.setUserId(commentsDto.getUserId());
            comment.setUsername(commentsDto.getUsername());
            comment.setPostId(commentsDto.getPostId());
            comment.setBody(commentsDto.getBody());
            return comment;
    }

    protected CommentsDto modelToDto(Comment comment) {
            if (comment == null) {
                    return null;
            }
            CommentsDto commentsDto = new CommentsDto();
            commentsDto.setId(comment.getId());
            commentsDto.setUserId(comment.getUserId());
            commentsDto.setUsername(comment.getUsername());
            commentsDto.setPostId(comment.getPostId());
            commentsDto.setBody(comment.getBody());
            return commentsDto;
    }

    @Override
    public Iterable<CommentsDto> getAllComments() {
        List<CommentsDto> postDtoList = new ArrayList<>();

		for (Comment comment : commentService.getAllComments()) {
			postDtoList.add(modelToDto(comment));
		}

	return postDtoList;
    }

    @Override
    public Iterable<CommentsDto> getComments(Map<String, String> queryMap) {
        if(queryMap.isEmpty()) {
            return getAllComments();
        }
        List<CommentsDto> postDtoList = new ArrayList<>();

            for (Comment comment : commentService.getComments(queryMap)) {
                postDtoList.add(modelToDto(comment));
            }

	return postDtoList;
    }

    @Override
    public CommentsDto addComments(CommentsDto comment) {
        return modelToDto(commentService.addComment(dtoToModel(comment)));
    }

}
