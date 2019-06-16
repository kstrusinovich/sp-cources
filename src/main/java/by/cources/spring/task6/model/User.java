package by.cources.spring.task6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Home
 */
@Entity
@Table(name = "user")
public class User
{
	/**  **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
  
	/**  **/
	@Column(name = "username")
	@NotBlank(message = "blank my custom message")
	private String username;
  
	/**  **/
	@Column(name = "password")
	@NotBlank(message = "blank my custom message")
	private String password;
  
	/**  **/
	@Column(name = "role")
	@NotBlank(message = "blank my custom message")
	private String role;
  
  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}	

	public void setRole(String role) {
		this.role = role;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	

}