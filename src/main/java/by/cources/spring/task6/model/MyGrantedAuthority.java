package by.cources.spring.task6.model;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
class MyGrantedAuthority implements GrantedAuthority
{
	private String role;
	
	public MyGrantedAuthority(String role) {
		System.out.println(role);
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return role;
	}
	
}

