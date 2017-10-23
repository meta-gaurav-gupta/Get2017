package com.metacube.angularwebapi.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;



public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
	private JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();
        protected abstract List<String> getColumnsName();

        @Override
	public <S extends T> S save(S entity) {
            try {
                    Connection connection = connectionFactory.getConnection();
                    Statement stmt = connection.createStatement();
                    String query = "INSERT INTO " + getTableName() + " VALUES (" + entity.toString() + ")";
                    System.out.println(query);
                    int resultSet = stmt.executeUpdate(query);
                    if(resultSet != -1)
                        return entity;
                    else
                        return null;
            } catch (Exception e) {
                    System.out.println(e);
                    return null;
            }
	}

        @Override
	public T findOne(final ID primaryKey)
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			//TODO - Logging
			return null;
		}
	}

        @Override
	public Iterable<T> findAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> list = new ArrayList<>();
			while(resultSet.next()) {
				list.add(extractResultSetRow(resultSet));
			}                      
			return list;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}

	}

        @Override
        public Iterable<T> findAll(Map<String, String> conditions) {
            try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
                        String condition = "";
                        for (String key : conditions.keySet()) {
                            if(key != null) {
                                condition += key + " = '" + conditions.get(key) + "' AND ";
                            }
                        }
                        condition = condition.substring(0, condition.length() - 5);
                        String query = "SELECT * FROM " + getTableName() + " where " 
                                + condition;
                        System.out.println(query);
			ResultSet resultSet = stmt.executeQuery(query);
			List<T> list = new ArrayList<>();
			while(resultSet.next()) {
				list.add(extractResultSetRow(resultSet));
			}
			return list;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}
        }

    
        
        @Override
	public Long count()
	{
		return null;
	}

        @Override
	public T delete(final ID primaryKey)
	{
            try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
                        T entity = findOne(primaryKey);
                        String query = "DELETE FROM " + getTableName() + " WHERE " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'";
                        System.out.println(query);
			int resultSet = stmt.executeUpdate(query);
			if(resultSet != -1)
                            return entity;
			return null;
		} catch (Exception e) {
			//TODO - Logging
			return null;
		}
	}

        @Override
	public boolean exists(final ID primaryKey)
	{
		return false;
	}
}
