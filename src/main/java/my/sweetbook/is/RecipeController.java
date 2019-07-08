package my.sweetbook.is;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecipeController {

  @Autowired
  private RecipeService recipeService;


  @RequestMapping("/recipes")
  public List<Recipe> getAllRecipes() {
    return recipeService.getAllRecipes();
  }

  @RequestMapping("/recipes/{id}")
  public Recipe getRecipe(@PathVariable String id) {
   return recipeService.getRecite(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/recipes")
  public void addRecipe(@RequestBody Recipe recipe) {
    recipeService.addRecipe(recipe);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/recipes/{id}")
  public void updateRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
    recipeService.updateRecipe(id, recipe);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/recipes/{id}")
  public void deleteRecipe(@PathVariable String id) {
    recipeService.deleteRecipe(id);
  }

}

