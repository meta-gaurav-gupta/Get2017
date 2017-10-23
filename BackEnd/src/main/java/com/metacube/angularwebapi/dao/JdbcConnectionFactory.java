package com.metacube.angularwebapi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory
{
	public Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/get_testdb", "get_user", "get_pwd");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
