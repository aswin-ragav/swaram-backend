package com.user.authorization.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Common {

	private static final String TEXT_HTML = "text/html";

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public BCryptPasswordEncoder getPasswordEncoder() { return passwordEncoder; }


	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {

		this.passwordEncoder = passwordEncoder;
	}


	/*
	 * 
	 * COMMON METHODS
	 * 
	 */
	public String encodePwd(String password) {

		return passwordEncoder.encode(password);
	}


	/*
	 * @params = String rawPassword, String encodedPassword
	 * 
	 * password[0] = rawPassword
	 * password[1] = encodedPassword
	 */
	public boolean decodePwd(String... password) {

		return passwordEncoder.matches(password[0], password[1]);
	}


	public String sendmail(String mailTo, String subject,
	                                    String content) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// @formatter:off
 
		Session session = Session.getInstance(props,
		                                    new javax.mail.Authenticator() {
			                                    @Override
			                                    protected PasswordAuthentication getPasswordAuthentication() {

				                                    return new PasswordAuthentication("aragav222@gmail.com",
				                                                                        "uyqajdutgpcsphxk");
			                                    }
		                                    });
		// @formatter:on
		Message msg = new MimeMessage(session);

		try {

			msg.setFrom(new InternetAddress("aragav222@gmail.com", false));
			msg.setRecipients(Message.RecipientType.TO,
			                                    InternetAddress.parse(mailTo));
			msg.setSubject(subject);
			msg.setContent(content, TEXT_HTML);
			msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(content, TEXT_HTML);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			// MimeBodyPart attachPart = new MimeBodyPart();
			//
			// attachPart.attachFile("/var/tmp/image19.png");
			// multipart.addBodyPart(attachPart);
			msg.setContent(multipart);
			Transport.send(msg);
			return "Mail sent...!!!";
		} catch (AddressException e) {

			e.printStackTrace();
			return "Mail not sent...!!!";
		} catch (MessagingException e) {

			e.printStackTrace();
			return "Mail not sent...!!!";
		}

	}
}
