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
  public List<Recipe> findAll() {
    return recipeService.findAll();
  }

  @GetMapping("{id}")
  public Recipe findById(@PathVariable int id) {
    return recipeService.findById(id);
  }

  @PostMapping
  public void save(@RequestBody Recipe recipe) {
    recipe.setCategories(categoryController.processUnique(recipe.getCategories()));
    recipeService.save(recipe);
  }

  @PutMapping
  public void update(@RequestBody Recipe recipe) {
    recipeService.save(recipe);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable int id) {
    recipeService.delete(id);
  }

}