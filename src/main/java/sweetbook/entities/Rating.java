package sweetbook.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Recipe recipe;

  private int value;

  public Rating(Recipe recipe, User user, int value) {
    this.recipe = recipe;
    this.user = user;
    this.value = value;
  }

  public Rating(int id, Recipe recipe, User user, int value) {
    this.id = id;
    this.recipe = recipe;
    this.user = user;
    this.value = value;
  }
}


