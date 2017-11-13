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

public class money  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();

    String username = req.getParameter("username");
	String role = req.getParameter("role");
	static sqlconnect sqlcon = new sqlconnect();
	
    public String m(){
    	ArrayList<ArrayList<String>> moneylist = sqlcon.money(username, role);
    	session.setAttribute("username", username);
		session.setAttribute("role", role);
		session.setAttribute("moneylist", moneylist);
		return SUCCESS;
    }
    
    
}
