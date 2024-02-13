package in.ashokit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.Repo.UserRepository;
import in.ashokit.entity.UserForm;
import in.ashokit.service.EmailServiceImp;
import jakarta.mail.MessagingException;

@Controller
public class UserController {
	
   @Autowired
	private EmailServiceImp emailService;
   @Autowired
   private UserRepository userRepo;
   
   //to load the form 
   @GetMapping("/form")
   public String form(Model model)
   {
	   model.addAttribute("UserForm", new UserForm());
	   return "userForm";
   }
   
   @PostMapping("/form")
   public String submitForm(UserForm userForm)
   {
	   emailService.insert(userForm);
	   
	   emailService.sendSimplemsg(userForm.getEmail(), "Verify your mail", "You have "
	   		+ "successfully completed registration with Amazon "
	   		+ "please click to verify below link"+"   " +"https://www.youtube.com/");
	   
	   return "redirect:/success";
   }
   
   @PostMapping("/attachMail")
   public String sendAttach(UserForm userForm)
   {   
	   try {
		emailService.sendMailAttachment(userForm.getEmail(), "Verify bro", "this is Email send project"
				+ "this is test project with attachment", "mem.jpg");
		return "success";
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "error";
	}
	   
	   
	   
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   @GetMapping("/success")
   public String showSuccessPage() {
       return "success";
   }
   
   
   @PostMapping("/gree")

   public String mymee(@RequestBody String name)
   {
	   return "hello ,"+name;
   }
   
   
   

}
