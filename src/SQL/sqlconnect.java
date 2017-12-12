package SQL;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.sql.*;
import pa.model;
import pa.chong;
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
		    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","wuzipeng");

	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		}
		catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		}
		return connect;
	}
	
	public int l(){
		int x = 0;

		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(x < y) x = y;
			}
			
		}catch (SQLException e){
				e.printStackTrace();
			}
		
			return x;
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
	
	public String geturl(String username){
		int ID = getID(username,"teacher");
		String url = "";
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");

			while(rs.next()){
				if(ID == rs.getInt("ID")){
					url = rs.getString("url");
				} 
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return url;
		
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
					ml.add(rs.getString("n"));
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
	public ArrayList<ArrayList<String>> zhuanye(){
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			ArrayList<String> zl = new ArrayList<String> ();	
			ArrayList<String> yl = new ArrayList<String> ();	
			while(rs.next()){
				String z = rs.getString("major");
				String y = rs.getString("院系");
				if(zl.contains(z)){
					
				}else zl.add(z);
				
				if(yl.contains(y)){
					
				}else yl.add(y);
			} 
			jiansuolist.add(yl);
			jiansuolist.add(zl);
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return jiansuolist;
		
	}
	
	public ArrayList<ArrayList<String>> jiansuo(String A, String B,String C) {
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				if(C.equals("")){
					if((rs.getString("院系").equals(A) || "ALL".equals(A)) && (rs.getString("major").equals(B) || "ALL".equals(B)) ){
						ArrayList<String> ml = new ArrayList<String> ();				
						
						int ID = rs.getInt("ID");
						ml.add(getname(ID,"teacher"));
						ml.add(rs.getString("院系"));
						ml.add(rs.getString("major"));
						ml.add(getusername(ID,"teacher"));
						ml.add(rs.getString("url"));
						jiansuolist.add(ml);
					} 
				}else{
					if(rs.getString("name").equals(C)){
		                   ArrayList<String> ml = new ArrayList<String> ();				
							
							int ID = rs.getInt("ID");
							ml.add(getname(ID,"teacher"));
							ml.add(rs.getString("院系"));
							ml.add(rs.getString("major"));
							ml.add(getusername(ID,"teacher"));
							ml.add(rs.getString("url"));
							jiansuolist.add(ml);
						}
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
	
	public ArrayList<ArrayList<String>> tuijian(String username,String role){
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();

		int ID = getID(username, "student");
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Student");

			while(rs.next()){
				if(rs.getInt("ID") == ID){
					String A = rs.getString("院系");
				
						jiansuolist = tj(A);
				
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
	
	public ArrayList<ArrayList<String>> tj(String A) {
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				if((rs.getString("院系").equals(A))){
					ArrayList<String> ml = new ArrayList<String> ();				
					
					int ID = rs.getInt("ID");
					ml.add(getname(ID,"teacher"));
					ml.add(rs.getString("院系"));
					ml.add(rs.getString("major"));
					ml.add(getusername(ID,"teacher"));
					ml.add(rs.getString("url"));

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

	public ArrayList<ArrayList<String>> appoint(String username, String role, int n) {
		int id = getID(username, "teacher");
		
		ArrayList<ArrayList<String>> keyanlist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from appoint");

			while(rs.next()){
				if(id == rs.getInt("teacherID") && rs.getInt("n") == n){
					ArrayList<String> ml = new ArrayList<String> ();				
					ml.add(String.valueOf(rs.getInt("ID")));
					ml.add(rs.getString("i"));
					ml.add(rs.getString("j"));
					ml.add(rs.getString("what"));
					int x = 0;
					for(x = 0; x < keyanlist.size(); x++){
						int i = Integer.valueOf(keyanlist.get(x).get(1));
						int j = Integer.valueOf(keyanlist.get(x).get(2));
						if((i == rs.getInt("i") && j > rs.getInt("j")) || (i > rs.getInt("i"))){
							break;
						}
					}
					
					keyanlist.add(x, ml);
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
	
	public void yy(int i , int j ,int n ,String teachername,String studentname){
		int tid = getID(teachername,"teacher");
		int sid = getID(studentname,"student");
		String sname = getname(sid,"student");
		int x = 0;
		try{
			
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Yuyue");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(x < y) x = y;
			}
		
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into Yuyue(ID,studentID,teacherID,"
																					+ "time,n) values(?,?,?,?,?)");
			ps.setInt(1,x + 1);
			ps.setInt(2, sid);
			ps.setInt(3, tid);
			ps.setString(4, "第" + n + "周的周" + j + "第" + i + "节课");
			ps.setInt(5, 0);
			ps.executeUpdate();
			ps.close();
			rs.close();
			statement.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			int z = 0;
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from appoint");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(z < y) z = y;
			}
	
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into appoint(ID,teacherID,n,i,j,"
																					+ "what,yID) values(?,?,?,?,?,?,?)");
			ps.setInt(1,z + 1);
			ps.setInt(2, tid);
			ps.setInt(3, n);
			ps.setInt(4, i);
			ps.setInt(5, j);
			ps.setString(6, sname + "已预约待审核");
			ps.setInt(7, x + 1);

			ps.executeUpdate();
			ps.close();
			rs.close();
			statement.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			
				int z = 0;
				Statement statement =getConnection().createStatement();
				ResultSet rs = statement.executeQuery("select * from Teacher");
				while(rs.next()){
					if(rs.getInt("ID") == tid){
						z = rs.getInt("Num") + 1;
					}
				}
			
			String sql = "update Teacher set Num =" + "'" + z + "'"+ " where username = " + "'" +teachername + "'";
		
			statement.executeUpdate(sql);
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void del(String ID,String X,String name){
		if(X.equals("1")){
			
			try{
				String sql1 = "update appoint set what=" + "'" + "预约成功" + "'"+ " where yID = " + "'" +ID + "'";
				Statement statement =getConnection().createStatement();
				statement.executeUpdate(sql1);
				statement.close();
				connect.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}else{
			try {
				String sql = "delete from appoint where yID ='" + ID + "'";
	
				PreparedStatement ps = (PreparedStatement) getConnection().prepareStatement(sql);
				ps.executeUpdate();
				ps.close();
	            connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try{
			String sql1 = "update Yuyue set n=" + "'" + X + "'"+ " where ID = " + "'" +ID + "'";
			Statement statement =getConnection().createStatement();
			statement.executeUpdate(sql1);
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			
			int z = 0;
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				if(rs.getString("name") == name){
					z = rs.getInt("Num") - 1;
				}
			}
		
		String sql1 = "update Teacher set Num =" + "'" + z + "'"+ " where username = " + "'" +name + "'";
	
		statement.executeUpdate(sql1);
		statement.close();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public void ty(int i , int j ,int n ,String teachername, String what) {
		int tid = getID(teachername,"teacher");


		try{
			int x = 0;
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from appoint");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(x < y) x = y;
			}
	
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into appoint(ID,teacherID,n,i,j,"
																					+ "what,yID) values(?,?,?,?,?,?,?)");
			ps.setInt(1,x + 1);
			ps.setInt(2, tid);
			ps.setInt(3, n);
			ps.setInt(4, i);
			ps.setInt(5, j);
			ps.setString(6, what);
			ps.setInt(7, -1);

			ps.executeUpdate();
			ps.close();
			rs.close();
			statement.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<String> g(String username, String role){
		int id = getID(username, role);
		
		ArrayList<String> keyanlist = new ArrayList<String> ();
		try{
			Statement statement =getConnection().createStatement();
		
		
				ResultSet rs = statement.executeQuery("select * from Student");

				while(rs.next()){
					if(id == rs.getInt("ID")){
						keyanlist.add(rs.getString("name"));
						keyanlist.add(rs.getString("sex"));
						keyanlist.add(rs.getString("tel"));
						keyanlist.add(rs.getString("major"));
						keyanlist.add(rs.getString("country"));
						keyanlist.add(rs.getString("出生日期"));
						keyanlist.add(rs.getString("入学日期"));
						keyanlist.add(rs.getString("民族"));
						keyanlist.add(rs.getString("年级"));
						keyanlist.add(rs.getString("班级"));
						keyanlist.add(rs.getString("院系"));
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

	public int getnum(String username) {
		int num = 0;
		int id = getID(username,"teacher");
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");

			while(rs.next()){
				if(id == rs.getInt("ID")){
					num = rs.getInt("Num");
				}
			}
			rs.close();
			statement.close();
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}

	

	public void pachong(model M){
		try{
			int x = 0;
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(x < y) x = y;
			}
	
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into Teacher(ID,name,院系,major,url,Num,username) values(?,?,?,?,?,?,?)");
			ps.setInt(1,x + 1);
			ps.setString(2, M.getName());
			ps.setString(3, M.getXueyuan());
			ps.setString(4, M.getMajor());
			ps.setString(5, M.getUrl());
			ps.setInt(6, 0);
			ps.setString(7, M.getUrl().substring(27));
			ps.executeUpdate();
			ps.close();
		
			
			
			rs.close();
			statement.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void pchong(model M){
		try{
			int x = 0;
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				int y = rs.getInt("ID");
				if(x < y) x = y;
			}
	
			
		
			PreparedStatement qs =(PreparedStatement) getConnection().prepareStatement("insert into Password(username,password,role,name,ID) values(?,?,?,?,?)");
			qs.setString(1, M.getUrl().substring(27));
			qs.setString(2, "111111");
			qs.setString(3, "teacher");
			qs.setString(4, M.getName());
			qs.setInt(5, x);
			qs.executeUpdate();

			qs.close();
			
			rs.close();
			statement.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
