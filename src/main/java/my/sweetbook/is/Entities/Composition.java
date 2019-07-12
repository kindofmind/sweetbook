package my.sweetbook.is.Entities;

import javax.persistence.*;

@Entity
@Table(name="compositions")
public class Composition {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private Ingredient ingredient;
  private long count;

  public Composition() {
  }

  public Composition(int id, Ingredient ingredient, long count) {
    this.id = id;
    this.ingredient = ingredient;
    this.count = count;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }
}
