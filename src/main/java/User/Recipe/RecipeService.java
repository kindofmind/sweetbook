package User.Recipe;

import my.sweetbook.is.Entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

  @Autowired
  private RecipeRepository recipeRepository;

  public List<Recipe> getAllRecipes() {
      return (List<Recipe>) recipeRepository.findAll();
  }

    public Recipe getRecite(int id) {
     return recipeRepository.findById(id).get();
  }

  public void addRecipe(Recipe recipe) {
      recipeRepository.save(recipe);
  }

  public void updateRecipe(Recipe recipe) {
      recipeRepository.save(recipe);
  }

  public void deleteRecipe(int id) {
    recipeRepository.deleteById(id);
  }


}
