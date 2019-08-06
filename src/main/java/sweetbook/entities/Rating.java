package sweetbook.entities;

import javax.persistence.*;

@Entity
public class Rating {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @ManyToOne
  @JoinColumn(name="recipe_id" )
  private Recipe recipe;
  private int value;



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


