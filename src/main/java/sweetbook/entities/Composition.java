package sweetbook.entities;

import javax.persistence.*;

@Entity
public class Composition {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne
  private Ingredient ingredient;

  private String count;

  public Composition() {
  }

  public Composition(Ingredient ingredient, String count) {
    this.ingredient = ingredient;
    this.count = count;
  }

  public Composition(int id, Ingredient ingredient, String count) {
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

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

}
