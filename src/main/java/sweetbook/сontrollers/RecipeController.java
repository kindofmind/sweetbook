package sweetbook.сontrollers;

import sweetbook.entities.*;
import sweetbook.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="recipe")
public class RecipeController {


  @Autowired
  private RecipeService recipeService;

  @Autowired
  private CategoryController categoryController;

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
    recipe.setCategories(categoryController.checkUnique(recipe.getCategories()));
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

  @GetMapping({"XX"})
  public void createTest() {
    Category category1 = new Category();
    category1.setName("Category1");
    Category category2 = new Category();
    category2.setName("Category2");
    Recipe recipe = new Recipe();
    Set<Category> categories = new HashSet<>(Arrays.asList(category1, category2));
    recipe.setCategories(categories);
    recipe.setName("Recipe1");
    addRecipe(recipe);
  }


}