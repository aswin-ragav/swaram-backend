package com.user.authorization.service;

import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.authorization.Interface.CRUD;
import com.user.authorization.common.Common;
import com.user.authorization.entity.Register;
import com.user.authorization.repository.RegisterRepository;

@Service
public class RegisterService implements CRUD<Register> {

	private static final Logger LOGGER    = LoggerFactory
	                                    .getLogger(RegisterService.class);
	private static final String TEXT_HTML = "text/html";

	@Autowired
	private RegisterRepository repository;

	@Autowired
	private Common common;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Register create(Register add) {

		LOGGER.info("Begin user creation ...");

		try {

			if (checkUserName(add.getUserName())) {

				return operationStatus(add, "UserName available !!!");
			}

			if (checkEmail(add.getMailId())) {

				return operationStatus(add, "Email available !!!");
			}

			String password = add.getPassword();

			if (password.equals(add.getCfnPassword())) {

				return initiateRegisterUser(add, password);
			}

		} catch (Exception e) {

			return operationStatus(add, "failed");
		}

		return operationStatus(add, "Password doesn't match");
	}


	private Register initiateRegisterUser(Register add, String password) {

		LOGGER.info("Initiate user creation ...");

		String randomUID = UUID.randomUUID().toString();

		add = registerNewUser(add, password, randomUID);

		sendVerificationEmail(randomUID);

		LOGGER.info("User creation successfull ---");

		return add;
	}


	private Register registerNewUser(Register add, String password,
	                                    String randomUID) {

		setAdditionalRegisterInfo(add, password, randomUID);

		return operationStatus(repository.save(add),
		                                    "registered");
	}


	private void setAdditionalRegisterInfo(Register add, String password,
	                                    String randomUID) {

		add.setPassword(common.encodePwd(password));
		add.setStatus("INACTIVE");
		add.setUniqueId(randomUID);
	}


	private void sendVerificationEmail(String randomUID) {

		String content = "http://localhost:8000/register/verify/"
		                                    + randomUID;
		sendToMailTopic(content);
	}


	@Override
	public Register read(long id) {

		Optional<Register> register = null;
		Register           message  = new Register();

		try {

			register = repository.findById(id);

			message.setEntityMessage("Id not found");

			return register.isPresent() ? register.get() : message;
		} catch (Exception e) {

			message.setEntityMessage("Error reading");
			return message;
		}

	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public Register update(Register register) {

		try {

			Optional<Register> findById = repository.findById(register.getId());
			Register           update   = findById.isPresent()
			                                    ? findById.get()
			                                    : null;

			if (update != null) {

				if (register.getMailId() != null) {

					update.setMailId(register.getMailId().trim());

				}

				if (register.getUserName() != null) {

					update.setUserName(register.getUserName().trim());
				}

				return operationStatus(repository.save(update), "updated");
			}

			return operationStatus(new Register(), "No record found");

		} catch (Exception e) {

			return operationStatus(register, "Error updating entity");
		}
	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean delete(long id) {

		try {

			repository.deleteById(id);
			return true;
		} catch (Exception e) {

			return false;
		}
	}


	public boolean checkUserName(String userName) {

		return (repository.verifyUserName(userName.trim()).isPresent())
		                                    ? true
		                                    : false;
	}


	public boolean checkEmail(String email) {

		return (repository.verifyEmail(email.trim()).isPresent()) ? true : false;
	}


	@Transactional(rollbackFor = Exception.class)
	public String activateAccount(String uuid) {

		try {

			boolean activateAccount = repository.findUniqueID(uuid) == 1;

			if (activateAccount) {

				Optional<Register> findUserById = repository.findUserById(uuid);

				sendToTopic(findUserById);

				return "Account Activated !!!";

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "Unable to Account Activated !!!";
	}


	private void sendToTopic(Optional<Register> findUserById) {

		kafkaTemplate.send("authorization_Topic", findUserById.get());
	}


	@KafkaListener(topics = "mail_topic", groupId = "group-id")
	public void listenMailTopic(String message) {

		String mailTo   = "ragavaswin@gmail.com";
		String subject  = "User verification mail";
		String sendmail = sendmail(mailTo, subject, message);

		System.out.println(sendmail);

	}


	public void sendToMailTopic(String message) {

		kafkaTemplate.send("mail_topic", message);
	}


	private Register operationStatus(Register register, String message) {

		register.setEntityMessage(message);
		return register;
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
