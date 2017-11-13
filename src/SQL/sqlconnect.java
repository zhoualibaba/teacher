package SQL;

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
				if((rs.getString("Ժϵ").equals(A) || "ALL".equals(A)) && (rs.getString("ְλ").equals(C) || "ALL".equals(C)) && (rs.getString("major").equals(B) || "ALL".equals(B)) && (rs.getString("sex").equals(D) || "ALL".equals(D))){
					ArrayList<String> ml = new ArrayList<String> ();				
					
					int ID = rs.getInt("ID");
					ml.add(getname(ID,"teacher"));
					ml.add(rs.getString("Ժϵ"));
					ml.add(rs.getString("major"));
					ml.add(rs.getString("ְλ"));
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
	
	public ArrayList<ArrayList<String>> tuijian(String username,String role,int a){
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();

		int ID = getID(username, "student");
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Student");

			while(rs.next()){
				if(rs.getInt("ID") == ID){
					String A = rs.getString("Ժϵ");
					String B = rs.getString("�꼶");
					if(a==0){
						jiansuolist = tj(A);
					}else{
						jiansuolist = tj(B);
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
	
	public ArrayList<ArrayList<String>> tj(String A) {
		ArrayList<ArrayList<String>> jiansuolist = new ArrayList<ArrayList<String>> ();
		try{
			Statement statement =getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Teacher");
			while(rs.next()){
				if((rs.getString("Ժϵ").equals(A)) || rs.getString("�꼶").equals(A)){
					ArrayList<String> ml = new ArrayList<String> ();				
					
					int ID = rs.getInt("ID");
					ml.add(getname(ID,"teacher"));
					ml.add(rs.getString("Ժϵ"));
					ml.add(rs.getString("major"));
					ml.add(rs.getString("ְλ"));
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
		try{
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into yuyue(ID,studentID,teacherID,"
																					+ "time) values(?,?,?,?)");
			ps.setInt(1,0);
			ps.setInt(2, sid);
			ps.setInt(3, tid);
			ps.setString(4, "��" + n + "�ܵ���" + j + "��" + i + "�ڿ�");
			ps.executeUpdate();
			ps.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			PreparedStatement ps =(PreparedStatement) getConnection().prepareStatement("insert into appoint(ID,teacherID,n,i,j,"
																					+ "what) values(?,?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setInt(2, tid);
			ps.setInt(3, n);
			ps.setInt(4, i);
			ps.setInt(5, j);
			ps.setString(6, sname + "��ԤԼ");
			ps.executeUpdate();
			ps.close();
			connect.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
}
