package utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailConfiguration {
	public static void main(String[] args) throws EmailException {
		
		System.out.println("====Test Started===");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("basant1894@gmail.com", "kuku0011"));
		email.setSSLOnConnect(true);
		email.setFrom("basant1894@gmail.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail from Selenium ...");
		email.addTo("basubasant94@gmail.com");
		email.send();
		
		System.out.println("====Mail Sent===");
		
		
	}

}
