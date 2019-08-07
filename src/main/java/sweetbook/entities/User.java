package sweetbook.entities;

import javax.persistence.*;


@Entity
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String login;
  private String firstName;
  private String lastName;
  private String moodMsg;
  private String password;


  public User() {
  }

  public User(String login, String firstName, String lastName, String moodMsg, String password) {
    this.login = login;
    this.firstName = firstName;
    this.lastName = lastName;
    this.moodMsg = moodMsg;
    this.password = password;
  }

  public User(int id, String login, String firstName, String lastName, String moodMsg, String password) {
    this.id = id;
    this.login = login;
    this.firstName = firstName;
    this.lastName = lastName;
    this.moodMsg = moodMsg;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFiestName() {
    return firstName;
  }

  public void setFiestName(String firstName) {
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
}
