package action;


import java.util.ArrayList;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;


public class yuyue  extends ActionSupport{
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
   	
    public String y(){
       	ArrayList<ArrayList<String>> yuyuelist = sqlcon.yuyue(username, role);
    
       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("yuyuelist", yuyuelist);
   		return SUCCESS;
    }
    
    public String yy(){
    	
       	String ID = req.getParameter("id");
       	String n = req.getParameter("n");
       	sqlcon.del(ID, n, username);
       	y();
   		return SUCCESS;
    }
    
}
