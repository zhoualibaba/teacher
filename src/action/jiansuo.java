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

import bsh.ParseException;

public class jiansuo  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();


	

    public String js(){
    	String Er = req.getParameter("Er");
     	String username = req.getParameter("username");
    	String A = "ALL";
    	String B = "ALL";
    	String C = "ALL";
     	String D = "ALL";
    	
     	session.setAttribute("username",username);
    	if(Er.equals("0")){

    	}else{ 
    		Er = "1";
    	
    		 A = req.getParameter("A");
        	 B = req.getParameter("B");
        	 C = req.getParameter("C");
         	 D = req.getParameter("D");
        	

    	}
    	session.setAttribute("A", A);
     	session.setAttribute("B", B);
     	session.setAttribute("C", C);
     	session.setAttribute("D", D);
    	session.setAttribute("Er", Er);
		return SUCCESS;
    }
    
    
}
