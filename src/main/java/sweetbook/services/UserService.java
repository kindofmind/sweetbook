package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.User;
import sweetbook.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void save(User user) {
    userRepository.save(user);
  }

  public User findByName(String name) {
    return userRepository.findByUsername(name);
  }

}
