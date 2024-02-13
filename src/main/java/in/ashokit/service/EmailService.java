package in.ashokit.service;

import in.ashokit.entity.UserForm;
import jakarta.mail.MessagingException;

public interface EmailService {

	
	
	//write one method to send messgae
	
	public void sendSimplemsg(String to,String subject,String text);
	
	
	//save record in database
	
	public void insert(UserForm userForm);
	
	
	//send mail with attachment
	
	public void sendMailAttachment(String to,String Subject,String text,String path) throws MessagingException ;
	
	
	
	
	
}
