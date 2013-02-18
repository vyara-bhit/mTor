package nl.bhit.webapp.action;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSendAction extends BaseAction {

	private static final long serialVersionUID = 1560673270745016979L;

	@SuppressWarnings("static-access")
	public void execute(Object[] recipients, String sender,  String subject, String bodyText) {					
		// Sender's email ID needs to be mentioned
		String from = sender;

		// Assuming you are sending email from gmail
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.put("mail.debug", "false");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.transport.protocol", "smtp");

		// Get the default Session object.
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(properties, auth);
		session.setDebug(true);
		Transport transport = null;
		try {
			transport = session.getTransport();
			if (transport != null){
				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					for (Object to :  recipients) {
						message.addRecipient(Message.RecipientType.TO, new InternetAddress((String)to));
					}

					// Set Subject: header field
					message.setSubject(subject);

					// Now set the actual message
					message.setText(bodyText);

					// Send message
					transport.connect();
					transport.send(message);
					transport.close();
					System.out.println("Sent message successfully....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}				
			}
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		
	}
	/**
	* SimpleAuthenticator is used to do simple authentication
	* when the SMTP server requires it.
	*/
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{
	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = "mtor.bhit@gmail.com";
	        String password = "viara123";
	        return new PasswordAuthentication(username, password);
	    }
	}
}


