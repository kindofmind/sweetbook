package sweetbook.entities;

import javax.persistence.*;

@Entity
public class Rating {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Recipe recipe;

  private int value;

  public Rating() {
  }

  public Rating(User user, Recipe recipe, int value) {
    this.user = user;
    this.recipe = recipe;
    this.value = value;
  }

  public Rating(int id, User user, Recipe recipe, int value) {
    this.id = id;
    this.user = user;
    this.recipe = recipe;
    this.value = value;
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

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}


