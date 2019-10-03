package sweetbook.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sweetbook.entities.Role;
import sweetbook.entities.User;

import javax.security.auth.Subject;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;

public class SweetUserPrincipal implements UserDetails {
  private User user;

  public SweetUserPrincipal(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    final List<GrantedAuthority> authorities = new ArrayList<>();
    for(Role role : user.getRoles()) { authorities.add(new SimpleGrantedAuthority(role.toString()));}
    return authorities;
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
    return user.isEnabled();
  }

  public User getUser() {
    return user;
  }
}
