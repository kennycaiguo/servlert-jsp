package com.site.db;
import java.sql.*;

public class DBConnection {
	
	Connection conn=null;
	Statement stmt=null;
	ResultSet  rs=null;
//
    private static final String KEY_MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/?useUnicode=true&characterEncoding=UTF-8";//"jdbc:mysql://localhost:3306/youyiku";
    private static final String KEY_MYSQL_USER = "root";
    private static final String KEY_MYSQL_PASSWORD = "";

  public DBConnection(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
	} catch(ClassNotFoundException e){
		System.out.println(e.getMessage());
    }
  }
  public ResultSet executeQuery(String sql){
	  try{
		  String url= KEY_MYSQL_URL;
	      String user= KEY_MYSQL_USER;
	      String password= KEY_MYSQL_PASSWORD;
		  conn=DriverManager.getConnection(url,user,password);
		  stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		  rs=stmt.executeQuery(sql);
	  }catch(SQLException ex){
		  System.out.println(ex.getMessage());
	  }
    return rs;
  }

  //传统JDBC，采用PreparedStatement 。预编译语句集，内置了处理SQL注入的能力
//  public ResultSet executeQuery2(String sql){
//      try{
//          String url= KEY_MYSQL_URL;
//          String user= KEY_MYSQL_USER;
//          String password= KEY_MYSQL_PASSWORD;
//          conn=DriverManager.getConnection(url,user,password);
////          stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//          PreparedStatement preparedStatement = conn.prepareStatement(sql);
//          rs= preparedStatement.executeQuery(sql);
//      }catch(SQLException ex){
//          System.out.println(ex.getMessage());
//      }
//      return rs;
//  }


  public int executeUpdate(String sql){
	   int result=0;
	  try{
		  String url= KEY_MYSQL_URL;
	      String user= KEY_MYSQL_USER;
	      String password= KEY_MYSQL_PASSWORD;
	      conn=DriverManager.getConnection(url,user,password);
		  stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		  result=stmt.executeUpdate(sql);
		 }catch(SQLException ex){
			result=0;
		 }
		 return result;
  }
  public void close(){
	  try{
		  if(rs!=null)rs.close();
	  }catch(Exception e){
		  e.printStackTrace(System.err);
	  }
	  try{
		  if(stmt!=null)stmt.close();
	  }catch(Exception e){
		  e.printStackTrace(System.err);
	  }
	  try{
		  if(conn!=null)conn.close();
	  }catch(Exception e){
		  e.printStackTrace(System.err);
	  }
	  
  }
 }
