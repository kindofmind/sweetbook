package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sweetbook.entities.Composition;
import sweetbook.entities.Ingredient;
import sweetbook.services.IngredientService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

  @Autowired
  private IngredientService ingredientService;

  @GetMapping("{name}")
  public List<Ingredient> findIngredientsByKeyword(@PathVariable String name) {
    return ingredientService.findByKeyword(name);
  }

  public Set<Composition> processUnique(Set<Composition> inCompositions) {
    Set<Composition> outCompositions = new HashSet<Composition>();
    if (inCompositions.size() > 0) {
      for (Composition composition : inCompositions) {
        if (ingredientService.existsByName(composition.getIngredient().getName())) 
          composition.setIngredient(ingredientService.findByName(composition.getIngredient().getName()));
        outCompositions.add(composition);
      }
    }
    return outCompositions;
  }

}
