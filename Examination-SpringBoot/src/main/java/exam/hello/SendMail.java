package exam.hello;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static String call(String email,String pass) {
		return sendPassword(email,pass);
	}
	public static String sendPassword(String email,String pass){  
		String ret=null;
		try{
		    System.out.println("mail entered");
		    final String AEMAIL="examhost845@gmail.com";
		    final String APASS="exam12345";
		   
		    String SUB="Examimation Portal";
		    String BODY="Your Password is '<b>" +pass+"</b>'";
		    Properties props=new Properties();
		    props.put("mail.smtp.host","smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port","465");
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth","true");
		    props.put("mail.smtp.port","465");
		    Session ses=Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication(){
		                	
		                    return new PasswordAuthentication(AEMAIL,APASS);
		                }
		            }
		            );
		    
		    Message message=new MimeMessage(ses);
		    message.setFrom(new InternetAddress(AEMAIL));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		    message.setSubject(SUB);
		    message.setContent(BODY,"text/html" );
		    Transport.send(message);
		    ret="Password has been sent to your mail";
		    System.out.println(ret);
		}
		catch(Exception ex){
		    ex.printStackTrace();
		    ret="Something went wrong";
		    System.out.println(ret);
		   
		}
		return ret;
		 }  
	   }  

