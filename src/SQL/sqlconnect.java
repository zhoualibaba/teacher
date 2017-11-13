package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.sql.*;


public class sqlconnect {
	public static Connection connect;  
	public static void drive() {
	}

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			//Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
		    connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teacher","root","wuzipeng");

	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
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
	
	public int getID(String username ,String role){
		int id = -1;
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Password");

			while(rs.next()){
				if(username.equals(rs.getString("username")) && role.equals(rs.getString("role"))){
					 id = rs.getInt("ID");
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}
	
	public String getname(int ID, String role){
		String name = null;
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Password");

			while(rs.next()){
				if(ID == rs.getInt("ID") && role.equals(rs.getString("role"))){
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
	
	public String getusername(int ID, String role){
		String name = null;
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Password");

			while(rs.next()){
				if(ID == rs.getInt("ID") && role.equals(rs.getString("role"))){
					name = rs.getString("username");
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
	
	public ArrayList<ArrayList<String>> money(String username, String role){
		int id = getID(username, "teacher");
		
		ArrayList<ArrayList<String>> moneylist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Money");

			while(rs.next()){
				if(id == rs.getInt("teacherID")){
					ArrayList<String> ml = new ArrayList<String> ();				
					ml.add(String.valueOf(rs.getInt("ID")));
					ml.add(rs.getString("what"));
					ml.add(rs.getString("money"));
					moneylist.add(ml);
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return moneylist;
	}
	
	public ArrayList<ArrayList<String>> keyan(String username, String role){
		int id = getID(username, "teacher");
		
		ArrayList<ArrayList<String>> keyanlist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Keyan");

			while(rs.next()){
				if(id == rs.getInt("teacherID")){
					ArrayList<String> ml = new ArrayList<String> ();				
					ml.add(String.valueOf(rs.getInt("ID")));
					ml.add(rs.getString("what"));
					keyanlist.add(ml);
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return keyanlist;
	}

	public ArrayList<ArrayList<String>> yuyue(String username, String role) {
		int id = getID(username,role);
		ArrayList<ArrayList<String>> yuyuelist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Yuyue");

			while(rs.next()){
				if((role.equals("teacher") && id == rs.getInt("teacherID")) || (role.equals("student") && id == rs.getInt("studentID"))){
					ArrayList<String> ml = new ArrayList<String> ();				
					ml.add(String.valueOf(rs.getInt("ID")));
					int studentID = rs.getInt("studentID");
					int teacherID = rs.getInt("teacherID");
					ml.add(getname(studentID,"student"));
					ml.add(getname(teacherID,"teacher"));
					ml.add(rs.getString("time"));
					yuyuelist.add(ml);
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return yuyuelist;
	}

	public ArrayList<ArrayList<String>> jiansuo(String A, String B, String C, String D) {
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				if((rs.getString("院系").equals(A) || "ALL".equals(A)) && (rs.getString("职位").equals(C) || "ALL".equals(C)) && (rs.getString("major").equals(B) || "ALL".equals(B)) && (rs.getString("sex").equals(D) || "ALL".equals(D))){
					ArrayList<String> ml = new ArrayList<String> ();				
					
					int ID = rs.getInt("ID");
					ml.add(getname(ID,"teacher"));
					ml.add(rs.getString("院系"));
					ml.add(rs.getString("major"));
					ml.add(rs.getString("职位"));
					ml.add(rs.getString("sex"));
					ml.add(getusername(ID,"teacher"));

					jiansuolist.add(ml);
				} 
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return jiansuolist;
	}
}
