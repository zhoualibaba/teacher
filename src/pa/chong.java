package pa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import SQL.sqlconnect;
import pa.model;
public class chong {
	static sqlconnect sqlcon = new sqlconnect();
	public static void C() {
		Ca("http://homepage.hit.edu.cn/neiye.jsp?mcpy=a");
		Ca("http://homepage.hit.edu.cn/neiye.jsp?mcpy=b");

	}
	 public static void Cc (String a){
		 model p = new model();
	    	try {
				Document doc = Jsoup.connect(a).get();
				Elements elements = doc.getElementsByClass("name tit36");
				String s = elements.text();
				if(s != null){
					p.setName(s);
					elements = doc.getElementsByClass("show-text1");
					String[] pp = elements.text().split(" "); 
					if(pp.length == 3){
						p.setXueyuan(pp[0]);
						p.setMajor(pp[1]);
						p.setUrl(a);
						sqlcon.pachong(p);
						sqlcon.pchong(p);
					}
				}
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
	 public static void Ca (String a){
	    	URL url = null;
	        URLConnection urlconn = null;
	        BufferedReader br = null;
//	        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
	        String regex = "http://homepage.hit.edu.cn/[A-Za-z]+";//url∆•≈‰πÊ‘Ú
	        Pattern p = Pattern.compile(regex);
	        try {
	            url = new URL(a);
	            urlconn = url.openConnection();
	            br = new BufferedReader(new InputStreamReader(
	                    urlconn.getInputStream()));
	            String buf = null;
	            while ((buf = br.readLine()) != null) {
	                Matcher buf_m = p.matcher(buf);
	                while (buf_m.find()) {
	                	String S = buf_m.group();
	                	if(S.equals("http://homepage.hit.edu.cn/help") || S.equals("http://homepage.hit.edu.cn/gy")){
	     	    	   }else{
	     	    		   Cc(S);
	     	    	   }
	                }
	            }
	            
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
