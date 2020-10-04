package master.springExtractor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import master.springExtractor.model.Role;
import master.springExtractor.model.User;

@Service
public interface UserService {

	public void setCurrentUser(User user);
    public Optional<User> getCurrentUser();
	
	Optional<User> findOne(Long id);
	List<User> findAll();
	User findByEmail(String email);
	List<User> findByRole(Role role);
	
	User save(User user);
	
}
