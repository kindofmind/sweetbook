package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sweetbook.entities.Role;
import sweetbook.entities.User;
import sweetbook.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public void save(@RequestBody User user) throws Exception {
    if (userService.findByName(user.getUsername()) != null) throw new UsernameAlreadyExistsException();
    if (!user.getPassword().matches(passwordPattern)) throw new BadPasswordException();
    if (!user.getUsername().matches(usernamePattern)) throw new BadUserNameException();
    if (user.getFirstName().isEmpty()) throw new EmptyFirstnameException();
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setEnabled(true);
    user.setRoles(new HashSet<>(Arrays.asList(Role.ROLE_USER)));
    System.out.println(user.getPassword());
    System.out.println(user.getUsername());
    System.out.println(user.getRoles());
    System.out.println(user.getFirstName());
    System.out.println(user.getLastName());
    System.out.println(user.getMoodMsg());
    userService.save(user);
  }

  @GetMapping(path = "/getuser")
  @ResponseBody
  public User getUserPrincipal(HttpServletRequest request) {
    Principal principal = request.getUserPrincipal();
    return userService.findByName(principal.getName());
  }

  @GetMapping(path = "register/checkusername/{name}")
  public Boolean checkUsernameFree(@PathVariable String name) {
    return userService.findByName(name) == null;
  }

  final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  final String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,12}$";
  final String usernamePattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,8}$";

  private class UsernameAlreadyExistsException extends Exception {
    public UsernameAlreadyExistsException() {
      super("The username already exists!");
    }
  }

  private class BadUserNameException extends Exception {
    public BadUserNameException() {
      super("Incorrect username format!");
    }
  }

  private class BadPasswordException extends Exception {
    public BadPasswordException() {
      super("Incorrect password format!");
    }
  }

  private class EmptyFirstnameException extends Exception {
    public EmptyFirstnameException() {
      super("Empty firstname!");
    }
  }

}
