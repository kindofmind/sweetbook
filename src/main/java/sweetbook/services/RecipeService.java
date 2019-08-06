package sweetbook.services;

import sweetbook.entities.Recipe;
import sweetbook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.сontrollers.CategoryController;

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

