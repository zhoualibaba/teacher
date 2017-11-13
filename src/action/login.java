package action;

/*
 * 导入数据库
 * 判断中的1
 * */
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class login  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    
    
    public String login_in() {
    	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String role = req.getParameter("role");
    	
    	
    	if(username.equals("1") && password.equals("3")){
    		session.setAttribute("username", username);
    		session.setAttribute("password", password);
    		session.setAttribute("role", role);
    		String name = "XXX";
    		session.setAttribute("name", name);
    		if(role.equals("teacher")){
        		String number = "0"; //数据库得到老师预约条数
        		session.setAttribute("num", number);
        	}
    	}else{
    		request.setAttribute("errorFlag", "1");
    		return "flase";
    	}
		return role;
    }
}
