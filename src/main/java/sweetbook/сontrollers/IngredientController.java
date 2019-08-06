package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sweetbook.entities.Ingredient;
import sweetbook.services.IngredientService;

import java.util.List;

@RestController
@RequestMapping(path="/ingredient")
public class IngredientController {

  @Autowired
  private IngredientService ingredientService;

  @GetMapping("{iname}")
  public List<Ingredient> findIngredient (@PathVariable String iname) {
    return ingredientService.findIngredient(iname);
  }
}
