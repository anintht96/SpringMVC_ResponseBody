package spring.mvc.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class User {

	@NotNull(message = "Id is required")
	private Integer id;
	
	@NotBlank(message = "Mame is required")
	@Length(min = 5,max = 15)
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
