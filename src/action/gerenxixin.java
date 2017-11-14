package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;

public class gerenxixin   extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    String username = req.getParameter("username");
	String role = req.getParameter("role");
	
	ArrayList<String> ddd = new ArrayList<String>();
	static sqlconnect sqlcon = new sqlconnect();
	 public String tg(){
	    	
		 	ddd = sqlcon.g(username, role);
			session.setAttribute("ddd", ddd);

	    	return role;
	    }
}
