package my.sweetbook.is;

import javax.persistence.*;


@Entity
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String login;
  private String fiestName;
  private String lastName;
  private String moodMsg;

  public User() {
  }

  public User(int id, String login, String fiestName, String lastName, String moodMsg) {
    super();
    this.id = id;
    this.login = login;
    this.fiestName = fiestName;
    this.lastName = lastName;
    this.moodMsg = moodMsg;
  }

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

  public String getFiestName() {
    return fiestName;
  }

  public void setFiestName(String fiestName) {
    this.fiestName = fiestName;
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
}
