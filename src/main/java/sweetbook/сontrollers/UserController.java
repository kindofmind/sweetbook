package sweetbook.сontrollers;

import com.mysql.cj.xdevapi.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sweetbook.entities.Role;
import sweetbook.entities.User;
import sweetbook.services.UserService;

import java.util.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public void save(@RequestBody User user) {
    userService.save(user);
  }

  @PutMapping
  public void update(@RequestBody User user) {
    userService.save(user);
  }

  @GetMapping(path = "/get/{name}")
  public User createUser(@PathVariable String name) {
    return userService.findByName(name);
  }

    @GetMapping(path = "/us")
  public void createUser() {
    User user = new User();
    user.setEnabled(true);
    user.setPassword("1");
    user.setUsername("user");
    user.setRoles(new HashSet<>(Arrays.asList(Role.ROLE_USER)));
    save(user);
  }

  @GetMapping(path = "/ad")
  public void createUser1() {
    User user1 = new User();
    user1.setEnabled(true);
    user1.setPassword("1");
    user1.setUsername("admin");
    user1.setRoles(new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)));
    save(user1);
  }




}
