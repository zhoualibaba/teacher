package action;

/*
 *30�е��÷���
 *role=role
 *username = username
 *����Ϊpassword
 * */
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class passwordchange  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    
    public String pwdchange() {
    	String username = req.getParameter("username");
    	String password = req.getParameter("newpassword");
    	String role = req.getParameter("role");
    	
    	request.setAttribute("errorFlag", "2");
		return SUCCESS;
    }
}