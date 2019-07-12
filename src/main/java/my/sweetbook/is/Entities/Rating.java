package my.sweetbook.is.Entities;

import javax.persistence.*;

@Entity
@Table(name="ratings")
public class Rating {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private User user;
  private Recipe recipe;
  private int rating;

  public Rating() {
  }

  public Rating(int id, User user, Recipe recipe, int rating) {
    this.id = id;
    this.user = user;
    this.recipe = recipe;
    this.rating = rating;
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

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}


