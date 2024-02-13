package in.ashokit.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.ashokit.Repo.UserRepository;
import in.ashokit.entity.UserForm;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailServiceImp implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UserRepository userRepo;

	@Override
	public void sendSimplemsg(String to, String subject, String text) {
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
		  
		
		
	}

	@Override
	public void insert(UserForm userForm) {
		
		userRepo.save(userForm);
		
		
	}

	@Override
	public void sendMailAttachment(String to, String Subject, String text, String path) throws MessagingException  {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setTo(to);
		helper.setSubject(Subject);
		helper.setText(text);
		
		File f=new File(path);
		
		FileSystemResource resource = new FileSystemResource(f);
		
		helper.addAttachment(resource.getFilename(), resource);
		
		javaMailSender.send(message);
		
		
	}

}
