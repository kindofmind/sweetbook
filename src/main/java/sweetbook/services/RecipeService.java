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

  public List<Recipe> findAll() {
    return (List<Recipe>) recipeRepository.findAll();
  }

  public Recipe findById(int id) {
    return recipeRepository.findById(id).get();
  }

  public void save(Recipe recipe) {
    recipeRepository.save(recipe);
  }

  public void delete(int id) {
    recipeRepository.deleteById(id);
  }


}

