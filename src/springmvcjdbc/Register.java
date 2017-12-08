package springmvcjdbc;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Register {

	private Long id;
	@NotNull
	@Size(min=5,max=16)
	private String userName;
	@NotNull
	private String firstName;
	private String lastName;
	@NotNull
	private String email;
	@NotNull
	@Size(min=5,max=16)
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
}
