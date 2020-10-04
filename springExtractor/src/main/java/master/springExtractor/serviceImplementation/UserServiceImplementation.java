package master.springExtractor.serviceImplementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import master.springExtractor.model.Role;
import master.springExtractor.model.User;
import master.springExtractor.repository.UserRepository;
import master.springExtractor.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void setCurrentUser(User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);		
	}

	@Override
	public Optional<User> getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Long id = Long.parseLong(auth.getName());
            return userRepository.findById(id);
        } catch (Exception e) {
        	return null;
        }
	}
	
	@Override
	public Optional<User> findOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

	@Override
	public User save(User user) {
		String file ="commonlyUsedPasswords.txt";
		List<String> pattern = new ArrayList<String>();
		
	    try{
	        InputStream ips = new FileInputStream(file); 
	        InputStreamReader ipsr = new InputStreamReader(ips);
	        BufferedReader br = new BufferedReader(ipsr);
	        String line;
	        
	        while ((line = br.readLine()) != null){
	        	pattern.add(line);
	        }
	        
	        br.close();
	    }       
	    catch (Exception e){
	        System.out.println("\n\n\t\tError trying to read from a file with commonly used passwords!\n");
	    } 
	    
	    for(int i = 0; i < pattern.size(); i++) {
	    	if(user.getPassword().equals(pattern.get(i))) {
	    		System.out.println("\n\n\t\t\tThe password is in the list of commonly used ones. You must select a new password!");
	    		return null;
	    	}
	    }
		
		return userRepository.save(user);
	}
	
}
