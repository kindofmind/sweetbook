package User.Ingredient;

import my.sweetbook.is.Entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

  @Autowired
  private IngredientService ingredientService;

  @RequestMapping("/ingredients")
  public List<Ingredient> getAllIngregients() {
    return ingredientService.getAllIngredients();
  }

}
