package my.sweetbook.is;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

 private List<Recipe> recipes =  new ArrayList<>(Arrays.asList(
        new Recipe("one", "salad1", "tomato & mayo!"),
        new Recipe("two", "salad2", "tomato & pepper & mayo!"),
        new Recipe("three", "salad3", "tomato & cucumber & pepper & mayo!")));

    public List<Recipe> getAllRecipes() {
      return recipes;
    }

    public Recipe getRecite(String id) {
     return recipes.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

  public void addRecipe(Recipe recipe) {
      recipes.add(recipe);
    }
}
