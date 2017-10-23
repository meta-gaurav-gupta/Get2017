package com.metacube.angularwebapi.dao.comment;

import com.metacube.angularwebapi.dao.GenericJdbcDao;
import com.metacube.angularwebapi.dao.JdbcConnectionFactory;
import org.springframework.stereotype.Component;
import com.metacube.angularwebapi.model.Comment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component("commentDao")
public class JdbcCommentDao extends GenericJdbcDao<Comment, Integer> implements CommentDao{
   
    private JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
    
    @Override 
    protected String getTableName()
    {
        return "Comment";
    }

    @Override 
    protected Comment extractResultSetRow(final ResultSet resultSet)
    {
        Comment comment = new Comment();


        try
        {
            comment.setPostId(resultSet.getInt("postId"));
            comment.setUserId(resultSet.getInt("userId"));
            comment.setUsername(resultSet.getString("username"));
            comment.setBody(resultSet.getString("body"));
            comment.setId(resultSet.getInt("id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return comment;
    }

    @Override 
    protected String getPrimaryKeyColoumnName()
    {
        return "id";
    }

    @Override
    protected List<String> getColumnsName() {
        List<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("postId");
        columns.add("userId");
        columns.add("username");
        columns.add("body");
        
        return columns;
    }

    @Override
    public <S extends Comment> Comment update(S entity) {
        Comment comment = entity;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + getTableName() + "SET" 
                    + "postId=" + comment.getPostId()
                    + "userId=" + comment.getUserId() 
                    + "username=" + comment.getUsername()
                    + "body=" + comment.getBody()
                    + "WHERE " + getPrimaryKeyColoumnName() + "=" + comment.getId();
            System.out.println(query);
            int resultSet = stmt.executeUpdate(query);
            if(resultSet != -1)
                return entity;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Comment> search(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

