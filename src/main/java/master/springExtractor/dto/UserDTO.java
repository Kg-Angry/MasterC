package master.springExtractor.dto;
import master.springExtractor.model.User;

public class UserDTO {
	
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private boolean active;
	
	public UserDTO() {
		
	}

	public UserDTO(String name, String surname, String email, String password, boolean active) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.active = active;
	}
	
	public UserDTO(User u)
	{
		this(u.getName(), u.getSurname(), u.getEmail(), u.getPassword(), u.isActive());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
