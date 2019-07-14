package my.sweetbook.is.Entities;

import javax.persistence.*;

@Entity
public class Composition {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @ManyToOne
  @JoinColumn(name="recipe_id")
  private Recipe recipe;
  @ManyToOne
  @JoinColumn(name = "ingredient_id")
  private Ingredient ingredient;
  private long count;


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

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
}
