package sweetbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sweetbook.entities.User;
import sweetbook.repositories.UserRepository;

@Service
public class SbUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userRepository.findByLogin(name);
    if (user == null) throw new UsernameNotFoundException(name);
    return new SbUserPrincipal(user);
  }
}
