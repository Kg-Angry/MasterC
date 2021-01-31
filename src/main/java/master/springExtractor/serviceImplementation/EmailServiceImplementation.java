package master.springExtractor.serviceImplementation;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import master.springExtractor.model.User;
import master.springExtractor.service.EmailService;
import master.springExtractor.service.UserService;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	@Autowired
	UserService userService;
	
	@Async
	@Override
	public void sendUserAccountActivation(User user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[SpringExtractor] User account activation");
		mail.setText("To activate your user account, please visit link below:\n http://localhost:8081/api/user/userAccountActivation/" + user.getEmail());
		javaMailSender.send(mail);
	}
	
	private String generatePassword() {	 
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
	    return generatedString;
	}

	@Override
	public void forgotPassword(User user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[SpringExtractor] Forgot password");
		
		String password = generatePassword();
		user.setPassword(password);
		userService.save(user);
		
		mail.setText("Username: " + user.getEmail() + "\nNew password: " + password);
		javaMailSender.send(mail);
	}

}
