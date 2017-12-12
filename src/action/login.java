
package action;

import java.io.IOException;

/*
 * 导入数据库
 * 判断中的1
 * */
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import SQL.sqlconnect;
import pa.chong;
public class login  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    static sqlconnect sqlcon = new sqlconnect();
    
    public String login_in() throws IOException {
    	if(sqlcon.l()==0) pa.chong.C();
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
    		   	
    	       		int number = sqlcon.getnum(username);
    	       		String url = sqlcon.geturl(username);
    	       		session.setAttribute("url", url);
        		session.setAttribute("num", number);
        	}
    	}else{
    		request.setAttribute("errorFlag", "1");
    		return "flase";
    	}
		return role;
    }
}

