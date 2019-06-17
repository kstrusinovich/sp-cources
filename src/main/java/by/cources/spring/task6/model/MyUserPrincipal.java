package by.cources.spring.task6.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		Set <MyGrantedAuthority> m = new HashSet<>();
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
