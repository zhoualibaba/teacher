package action;


import java.util.ArrayList;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;


public class tuijian  extends ActionSupport{
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
   	
    public String t(){
       	ArrayList<ArrayList<String>> tuijianlist = sqlcon.tuijian(username, role,0);
       	ArrayList<ArrayList<String>> tl = sqlcon.tuijian(username, role,1);

       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("tuijianlist", tuijianlist);
   		session.setAttribute("tl", tl);

   		return SUCCESS;
    }
    
}
