
package action;

/*
 * �������ݿ�
 * �ж��е�1
 * */
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;

public class login  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    static sqlconnect sqlcon = new sqlconnect();
    
    public String login_in() {
    	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String role = req.getParameter("role");
    	String name = sqlcon.login(username, role, password);
    	
    	if(name.length() != 0){
    		session.setAttribute("name", name);
    		session.setAttribute("username", username);
    		session.setAttribute("password", password);
    		session.setAttribute("role", role);
    		if(role.equals("teacher")){
        		String number = "0"; //���ݿ�õ���ʦԤԼ����
        		session.setAttribute("num", number);
        	}
    	}else{
    		request.setAttribute("errorFlag", "1");
    		return "flase";
    	}
		return role;
    }
}

