package exam.hello;

import java.util.List;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.web.client.RestTemplate;

public class E {

	public static void main(String[] args) {
		// suppose postman goes to post office
		String url ="http://localhost:8099";
		RestTemplate t =new RestTemplate();
		
		registration x = t.getForObject(url+"/pw?x=1",registration.class);
		System.out.println("Single select");
		  System.out.println(x);
		 
		
		/*
		 * List l = t.getForObject(url+"/ms",List.class); System.out.println(l.size());
		 */
		
//		  registration z =new registration(1,"NewName","City","UPDX","zyx","M","Paswiehd",2536372);
//		  Registration q = t.postForObject("http://localhost:8099/upd", z, Registration.class);
//		System.out.println(q);
//		
		
		
		
		
		
		
		
		
		

	}

}
