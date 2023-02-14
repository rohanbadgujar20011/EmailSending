import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
public class JavaMail {
	public static void Mail(String name,String email,String subject,String mess){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
         new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication("rohanbadgujar1981@gmail.com","vyrfmsejuepurdtp");//change accordingly
         }
        });

      //compose message
        try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress("rohanbadgujar1981@gmail.com"));//change accordingly
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
         message.setSubject(subject);
    
         message.setContent(mess,"text/html");

         //send message
         Transport.send(message);

         System.out.println("message sent successfully");

        } catch (MessagingException e) {throw new RuntimeException(e);}
	      
	   }  

	
		
	
	 public static void main(String [] args){  
	      
}
	}
