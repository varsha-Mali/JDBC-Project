package org.AlumniaSystem.Config;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DBConfig 
{  
	 private static Connection conn;
	 private static PreparedStatement stmt;
	 private static  ResultSet rs;
	
    private static DBConfig db=null;
	private DBConfig()
	{
		try
		{
			
			Properties p=new Properties();
			p.load(PathHelper.fin);
			String driverClassName=p.getProperty("driver.classname");
			//System.out.println(driverClassName);
			String username=p.getProperty("db.username");
			//System.out.println(username);
			String password=p.getProperty("db.password");
			//System.out.println(password);
			String url=p.getProperty("db.url");
			//System.out.println(url);
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null)
			{
				System.out.println("Database Connected SuccessFully...");
			}
			else
			{
				System.out.println("Database Not Connected");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
	}
	public static DBConfig getDBInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
	public static Connection getConnection()
	{
		return conn;
	}
	public static PreparedStatement getStatement()
	{
		return stmt;
	}
    public static ResultSet getResultSet()
    {
    	return rs;
    }

}
