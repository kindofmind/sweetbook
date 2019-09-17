package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import sweetbook.entities.Recipe;
import sweetbook.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping(path="recipe")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @Autowired
  private CategoryController categoryController;


  @GetMapping("/all")
  public List<Recipe> findAll()
  {
    return recipeService.findAll();
  }

  @GetMapping("/pagecount")
  public int getPageCount()
  {
    return recipeService.findAll(PageRequest.of(0, 10)).getTotalPages();
  }

  @GetMapping("/page/{page}")
  public List<Recipe> findAllPageable(@PathVariable int page)
  {
     return recipeService.findAll(PageRequest.of(page, 10)).getContent();
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