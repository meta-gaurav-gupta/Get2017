package com.metacube.angularwebapi.dao.post;

import com.metacube.angularwebapi.dao.GenericJdbcDao;
import com.metacube.angularwebapi.dao.JdbcConnectionFactory;
import com.metacube.angularwebapi.model.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("postDao")
public class JdbcPostDao extends GenericJdbcDao<Post, Integer> implements PostDao{
   
    private JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
    
    @Override 
    protected String getTableName()
    {
        return "Post";
    }

    @Override 
    protected Post extractResultSetRow(final ResultSet resultSet)
    {
        Post post = new Post();


        try
        {
            post.setUserId(resultSet.getInt("userId"));
            post.setUserName(resultSet.getString("username"));
            post.setBody(resultSet.getString("body"));
            post.setId(resultSet.getInt("id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return post;
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
        columns.add("userId");
        columns.add("username");
        columns.add("body");
        
        return columns;
    }

    @Override
    public <S extends Post> Post update(S entity) {
        Post post = entity;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + getTableName() + " SET " 
                    + "userId = " + post.getUserId() 
                    + ", username = '" + post.getUserName()
                    + "', body = '" + post.getBody()
                    + "' WHERE " + getPrimaryKeyColoumnName() + " = " + post.getId();
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
    public Iterable<Post> search(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
