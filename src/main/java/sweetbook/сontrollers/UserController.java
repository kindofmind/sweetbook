package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sweetbook.entities.User;
import sweetbook.services.UserService;

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
}
