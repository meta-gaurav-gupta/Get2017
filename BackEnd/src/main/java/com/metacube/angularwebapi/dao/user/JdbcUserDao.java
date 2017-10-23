package com.metacube.angularwebapi.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.angularwebapi.dao.GenericJdbcDao;
import com.metacube.angularwebapi.dao.JdbcConnectionFactory;
import com.metacube.angularwebapi.model.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JdbcUserDao extends GenericJdbcDao<User, Integer> implements UserDao
{

    private JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
    
	@Override protected String getTableName()
	{
		return "User";
	}

	@Override protected User extractResultSetRow(final ResultSet resultSet)
	{
		User user = new User();


		try
		{
			user.setName(resultSet.getString("name"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
                        user.setWebsite(resultSet.getString("website"));
			user.setId(resultSet.getInt("id"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}


		return user;
	}

	@Override protected String getPrimaryKeyColoumnName()
	{
		return "id";
	}

    @Override
    protected List<String> getColumnsName() {
        List<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("username");
        columns.add("email");
        columns.add("website");
        
        return columns;
    }

    @Override
    public <S extends User> User update(S entity) {
        User user = entity;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + getTableName() + "SET" 
                    + "name=" + user.getName()
                    + "username=" + user.getUsername()
                    + "email=" + user.getEmail()
                    + "website=" + user.getWebsite()
                    + "WHERE " + getPrimaryKeyColoumnName() + "=" + user.getId();
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
    public Iterable<User> search(String query) {
        try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
                        String queryStatement = "SELECT * FROM " + getTableName() + " WHERE " + "name LIKE '" + query + "%'";
                        System.out.println(queryStatement);
			ResultSet resultSet = stmt.executeQuery(queryStatement);
			List<User> list = new ArrayList<>();
			while(resultSet.next()) {
				list.add(extractResultSetRow(resultSet));
			}                      
			return list;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}
    }

}
