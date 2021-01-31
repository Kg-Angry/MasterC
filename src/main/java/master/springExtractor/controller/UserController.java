package master.springExtractor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import master.springExtractor.dto.UserDTO;
import master.springExtractor.model.Role;
import master.springExtractor.model.User;
import master.springExtractor.repository.UserRepository;
import master.springExtractor.service.EmailService;
import master.springExtractor.service.UserService;

@CrossOrigin("https://springextractor.herokuapp.com")
@RestController
@RequestMapping(value = "api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService emailService;
	
	//preuzimanje korisnika sa zadatim id-em
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		if (userService.findOne(id) == null) 
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);	
		else		
			return new ResponseEntity<User>(userService.findOne(id).get(), HttpStatus.OK);
	}
	
	//preuzimanje svih korisnika
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();
					
		if(users.equals(null)) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
					
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//registracija korisnika
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registration(@RequestBody UserDTO request) {		
		User user = new User(request.getName(), request.getSurname(), request.getEmail(), request.getPassword()); 
			
		for(User u : userService.findAll()) {
			if(!u.getEmail().equals(user.getEmail())) {
				if(!user.getEmail().isEmpty() && !user.getName().isEmpty() && !user.getSurname().isEmpty() && !user.getPassword().isEmpty()) {
					user.setRole(Role.TEACHER);
					emailService.sendUserAccountActivation(user);
					User us = userService.save(user);
					if(us != null)
						return new ResponseEntity<User>(user, HttpStatus.OK);
					else
						return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
				} else
					return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
			}
		}
				
		return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
	}
	
	//aktivacija korisnickog naloga posetom linka iz mejla
	@RequestMapping(value = "/userAccountActivation/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> userAccountActivation(@PathVariable String email) {
		List<User> users = userService.findAll();
			
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email/*+".com"*/)) {
				User u = users.get(i);
				u.setActive(true);
				userService.save(u);
				return new ResponseEntity<User>(u, HttpStatus.OK);
			}
		}
			
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	//logovanje korisnika
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO request) {
		User user = userService.findByEmail(request.getEmail());
			
		if(user != null) {
			if(user.getPassword().equals(request.getPassword()) && user.isActive()) {			
				userService.setCurrentUser(user);
				return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
			} else if(!user.isActive()) {
				System.out.println("\n\t\tKorisnicki nalog nije aktiviran!\n");
				return new ResponseEntity<>(new UserDTO(user), HttpStatus.I_AM_A_TEAPOT);
			}else {
				System.out.println("\n\t\tNe postoji korisnik sa unetim emailom i lozinkom u bazi!\n");
				return new ResponseEntity<>(new UserDTO(user), HttpStatus.NOT_FOUND);
			}
		}
				
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
	}
	
	//preuzimanje aktivnog korisnika
	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getCurrentUser(){
		if(userService.getCurrentUser() == null)
			return null;	
		else		
			return new ResponseEntity<User>(userService.getCurrentUser().get(), HttpStatus.OK);
	}
	
	//odjava korisnika
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<User> logout() {
		if(userService.getCurrentUser() != null)
			SecurityContextHolder.clearContext();
			
		return new ResponseEntity<User>(userService.getCurrentUser().get(), HttpStatus.OK);
	}
	
	//zaboravljena lozinka
	@RequestMapping(value = "/forgotPassword/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> forgotPassword(@PathVariable String email) {
		if(!email.isEmpty()) {
			User user = userService.findByEmail(email);
			
			if(user!= null) {
				emailService.forgotPassword(user);
				return new ResponseEntity<User>(HttpStatus.OK);
			}
		} 
		
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

}
