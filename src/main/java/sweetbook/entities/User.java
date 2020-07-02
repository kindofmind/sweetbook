package sweetbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @Column(name = "username", unique = true, nullable = false, length = 50)
  private String username;

  @Column(name = "firstname", length = 50)
  private String firstName;

  @Column(name = "lastname", nullable = true, length = 50)
  private String lastName;

  @Column(name = "moodmsg", nullable = true, length = 50)
  private String moodMsg;

  @Column(name = "password", nullable = false, length = 100)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(name = "enabled", nullable = false, columnDefinition = "tinyint(4)")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private boolean enabled;

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<Role> roles;

}
