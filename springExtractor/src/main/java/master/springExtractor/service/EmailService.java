package master.springExtractor.service;

import org.springframework.stereotype.Service;

import master.springExtractor.model.User;

@Service
public interface EmailService {

	void sendUserAccountActivation(User user);
	void forgotPassword(User user);
	
}
