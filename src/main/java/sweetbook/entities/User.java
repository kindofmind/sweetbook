package sweetbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @Column(name="username",  nullable = false, length = 50)
  private String login;
  private String firstName;
  private String lastName;
  private String moodMsg;
  @Column(name="password", nullable = false, length = 50)
  @JsonIgnore
  private String password;
  @Column(name="enabled", nullable = false)
  private boolean isEnabled;
  @Enumerated(EnumType.STRING)
  private Role role;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMoodMsg() {
    return moodMsg;
  }

  public void setMoodMsg(String moodMsg) {
    this.moodMsg = moodMsg;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
