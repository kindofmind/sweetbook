package my.sweetbook.is.Controllers;

import my.sweetbook.is.Entities.Recipe;
import my.sweetbook.is.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @GetMapping
  public List<Recipe> getAllRecipes() {
    return recipeService.getAllRecipes();
  }

  @GetMapping("{id}")
  public Recipe getRecipe(@PathVariable int id) {
    return recipeService.getRecite(id);
  }

  @PostMapping
  public void addRecipe(@RequestBody Recipe recipe) {
    recipeService.addRecipe(recipe);
  }

  @PutMapping("{id}")
  public void updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
    recipeService.updateRecipe(recipe);
  }

  @DeleteMapping("{id}")
  public void deleteRecipe(@PathVariable int id) {
    recipeService.deleteRecipe(id);
  }

}