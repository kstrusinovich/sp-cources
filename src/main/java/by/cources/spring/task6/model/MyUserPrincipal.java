package by.cources.spring.task6.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyUserPrincipal implements UserDetails 
{
	/**  **/
	private User user;
	 
	
	public MyUserPrincipal(User user) 
	{
	   this.user = user;
	}

	class MyGrantedAuthority implements GrantedAuthority
	{
		private String role;
		
		public MyGrantedAuthority(String role) {
			this.role = role;
		}
		
		@Override
		public String getAuthority() {
			return role;
		}
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		List <MyGrantedAuthority> m = new ArrayList<>();
		System.out.println(user.getRole());
		m.add( new MyGrantedAuthority( user.getRole()) ); 
		return m;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
