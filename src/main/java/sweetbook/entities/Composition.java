package sweetbook.entities;

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
  private String count;


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

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
}
