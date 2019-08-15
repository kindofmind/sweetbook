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

   @GetMapping({"XX"})
  public void testadd() {
     Category category1 = new Category();
     category1.setName("cat1");

     Category category2 = new Category();
     category2.setName("cat2");

     Ingredient ingredient1 = new Ingredient();
     ingredient1.setName("Ing1");

     Ingredient ingredient2 = new Ingredient();
     ingredient2.setName("Ing2");

     Composition composition1 = new Composition();
     composition1.setIngredient(ingredient1);
     composition1.setCount("ing 1 MNOGO");

     Composition composition2 = new Composition();
     composition2.setIngredient(ingredient2);
     composition2.setCount("ing 2 MNOGO");

    Recipe recipe = new Recipe();
    recipe.setCategories(new HashSet<>(Arrays.asList(category1, category2)));
    recipe.setCompositions(new HashSet<>(Arrays.asList(composition1, composition2)));
    recipe.setName("Recipe1");
    recipe.setDesctiption("Recipe 1 Description");
    recipe.setAlgorithm("Recipe 1 Algorithm");

    save(recipe);
  }



}