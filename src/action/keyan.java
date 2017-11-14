package action;



import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;

public class keyan  extends ActionSupport{
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
   	
    public String k(){
       	ArrayList<ArrayList<String>> keyanlist = sqlcon.keyan(username, role);
       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("keyanlist", keyanlist);
   		return SUCCESS;
    }
    
    public String ck(){
       	ArrayList<ArrayList<String>> keyanlist = sqlcon.keyan(username, role);
       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("keyanlist", keyanlist);
   		return SUCCESS;
    }
    
    public String dk(){
    	String ID = req.getParameter("ID");
    	sqlcon.del(ID,"Keyan");
       	ArrayList<ArrayList<String>> keyanlist = sqlcon.keyan(username, role);
       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("keyanlist", keyanlist);
   		return SUCCESS;
    }
    
    public String tk(){
    	String what = req.getParameter("what");
    	sqlcon.tk(username, what);
       	ArrayList<ArrayList<String>> keyanlist = sqlcon.keyan(username, role);
       	session.setAttribute("username", username);
   		session.setAttribute("role", role);
   		session.setAttribute("keyanlist", keyanlist);
   		return SUCCESS;
    }
    
}
