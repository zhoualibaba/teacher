package action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;

public class appoint  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String username = req.getParameter("username");
	String role = req.getParameter("role");
	String sname = req.getParameter("sname");

	static sqlconnect sqlcon = new sqlconnect();
	
	ArrayList<String> ddd = new ArrayList<String>();
    public String app() {
    	
    	
    	Date date = null;
    	Date nowdate = new Date();
    	
		try {
			date = sdf.parse("2017-9-3");
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(1);
		int d = (int) getDatePoor(nowdate,date);
		int n = d / 7 + 1;
		
		a(n);
		return SUCCESS;
    }
    
    public String next(){
    	String nn = req.getParameter("n");
    	int n = Integer.valueOf(nn) + 1;
    	a(n);
    	return SUCCESS;
    }
    
    public String before(){
   
    	String nn = req.getParameter("n");
    	int n = Integer.valueOf(nn) - 1;
    	a(n);
    	return SUCCESS;
    }
    
    public String y(){
    	String i = req.getParameter("i");
    	String j = req.getParameter("j");
    	String n = req.getParameter("n");
    	sqlcon.yy(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), username, sname);
    	a(Integer.valueOf(n));
    	return SUCCESS;
    }
    
    public String ty(){
    	String i = req.getParameter("i");
    	String j = req.getParameter("j");
    	String n = req.getParameter("n");
    	String what = req.getParameter("what");
    	sqlcon.ty(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), username,what);
    	a(Integer.valueOf(n));
    	return SUCCESS;
    }
    
    public void a(int n ){
    
    	Date date = null;
    	Date nowdate = new Date();
    	
		try {
			date = sdf.parse("2017-9-3");
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, n * 7 - 7);
		for(int i = 1; i < 8 ;i ++){
			calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�

			date=calendar.getTime(); //���ʱ���������������һ��Ľ��
			String putDate = sdf.format(date); //����һ�������� 
			//System.out.println(putDate);
			ddd.add(putDate);
		}
    	ArrayList<ArrayList<String>> applist = sqlcon.appoint(username, role,n);
		session.setAttribute("applist", applist);

		String ndate = sdf.format(nowdate);
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		session.setAttribute("sname", sname);

		session.setAttribute("n", String.valueOf(n));
		session.setAttribute("ndate", ndate);
		session.setAttribute("ddd", ddd);
		
	//	ddd.clear();
		
    }
    
    public static long getDatePoor(Date endDate, Date nowDate) {
    	 
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // �������ʱ��ĺ���ʱ�����
        long diff = endDate.getTime() - nowDate.getTime();
        // ����������
        long day = diff / nd;
        // ��������Сʱ
        long hour = diff % nd / nh;
        // �������ٷ���
        long min = diff % nd % nh / nm;
        // ����������//������
        // long sec = diff % nd % nh % nm / ns;
        return day;
    }
    public static void sort(ArrayList<ArrayList<String>> applist){
    	for(int i = 0 ; i < applist.size(); i ++){
    		for(int j = applist.size() - 1; j > i ; j --){
    			if(Integer.valueOf(applist.get(j).get(1)) <  Integer.valueOf(applist.get(j - 1).get(1))){
    				
    			}
    		}
    	}
    }
}
