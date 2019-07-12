package my.sweetbook.is.Entities;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="recipes")
public class Recipe {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private User user;
  private Set<Category> categories;
  private Set<Composition> compositions;
  private String name;
  private String desctiption;
  private String algorithm;

  public Recipe() {
  }

  public Recipe(int id, User user, Set<Category> categories, String name, String desctiption, String algorithm) {
    this.id = id;
    this.user = user;
    this.categories = categories;
    this.name = name;
    this.desctiption = desctiption;
    this.algorithm = algorithm;
  }

  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public int getId() {
    return id;
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
