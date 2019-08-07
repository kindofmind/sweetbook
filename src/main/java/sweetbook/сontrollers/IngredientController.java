package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sweetbook.entities.Ingredient;
import sweetbook.services.IngredientService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/ingredient")
public class IngredientController {

  @Autowired
  private IngredientService ingredientService;

  @GetMapping("{name}")
  public List<Ingredient> findIngredientsByKeyword (@PathVariable String name) {
    return ingredientService.findByKeyword(name);
  }

/*  public Set<Ingredient> processUnique(Set<Ingredient> ingredients) {
    Set<Ingredient> procIngredients = new HashSet<Ingredient>();
    if (ingredients.size() > 0) {
      for (Ingredient ingredient : ingredients) {
        if (ingredientService.existsByName(ingredient.getName()))
          procIngredients.add(ingredientService.findByName(ingredient.getName()));
        else procIngredients.add(ingredient);
      }
    }
    return procIngredients;
  }*/


}
