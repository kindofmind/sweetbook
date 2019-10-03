package sweetbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "username", nullable = false, length = 50)
  private String username;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "moodmsg")
  private String moodMsg;

  @Column(name = "password", nullable = false, length = 50)
  @JsonIgnore
  private String password;

  @Column(name = "enabled", nullable = false, columnDefinition = "tinyint(4)")
  private boolean enabled;

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;

}
