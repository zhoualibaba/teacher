package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.sql.*;


public class sqlconnect {
	public static Connection connect;  
	public static void drive() {
	}

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			//Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
		    connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teacher","root","wuzipeng");

	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
		}
		catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		}
		return connect;
	}
	
	public String login(String username, String role,String password){
		String name = "";
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Password");

			while(rs.next()){
				if(username.equals(rs.getString("username")) && role.equals(rs.getString("role")) && password.equals(rs.getString("password")) ){
					 name = rs.getString("name");
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return name;
	}
	
	public void passwordchange(String username, String role,String password){
		try{
			String sql = "update Password set password=" + "'" + password + "'"+ " where username = " + "'" +username + "'";
			Statement statement =getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
