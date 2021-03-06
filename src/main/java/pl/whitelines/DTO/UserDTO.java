package pl.whitelines.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
	@NotNull(message= "{NotNull.UserDTO.login.validation}")
	@Size(min=5, max=20, message="{Size.UserDTO.login.validation}")
	@Pattern(regexp="^[a-z0-9]+$", message="{Pattern.UserDTO.login.validation}")
	private String username;
	@Size(min=5, max=20, message="{Size.UserDTO.password.validation}")
	private String password;
	 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
