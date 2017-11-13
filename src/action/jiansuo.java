package action;


import java.io.UnsupportedEncodingException;
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

public class jiansuo  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();

    String username = req.getParameter("username");
   	static sqlconnect sqlcon = new sqlconnect();
	

    public String js(){
    	String Er = req.getParameter("Er");
    	String A = "ALL";
    	String B = "ALL";
    	String C = "ALL";
     	String D = "ALL";
    	
     	session.setAttribute("username",username);
    	if(Er.equals("0")){

    	}else{ 
    		Er = "1";
    		
    		 A = req.getParameter("yuanxi");
        	 B = req.getParameter("major");
        	 C = req.getParameter("zhiwei");
         	 D = req.getParameter("sex");
        	
         	 try {
 				A = new String(A.getBytes("8859_1"), "utf8");
 				B = new String(B.getBytes("8859_1"), "utf8");
 				C = new String(C.getBytes("8859_1"), "utf8");
 				D = new String(D.getBytes("8859_1"), "utf8");
 			} catch (UnsupportedEncodingException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
         	ArrayList<ArrayList<String>> jiansuolist = sqlcon.jiansuo(A,B,C,D);
         	session.setAttribute("j", jiansuolist);

    	}
    	session.setAttribute("A", A);
     	session.setAttribute("B", B);
     	session.setAttribute("C", C);
     	session.setAttribute("D", D);
    	session.setAttribute("Er", Er);
    	

		return SUCCESS;
    }
    
    
}
