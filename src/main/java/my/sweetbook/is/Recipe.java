package my.sweetbook.is;

import javax.persistence.*;

@Entity
public class Recipe {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @OneToMany
  private User user;
  private String name;
  private String desctiption;

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  private String algorithm;


  public int getId() {
    return id;
  }

  public Recipe() {
  }

  public Recipe(int id, User user, String name, String desctiption, String algorithm) {
    super();
    this.id = id;
    this.user = user;
    this.name = name;
    this.desctiption = desctiption;
    this.algorithm = algorithm;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesctiption() {
    return desctiption;
  }

  public void setDesctiption(String desctiption) {
    this.desctiption = desctiption;
  }
}
