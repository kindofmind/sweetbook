package User.Ingredient;

import my.sweetbook.is.Entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

  @Autowired
  private IngredientRepo ingredientRepo;

  public List<Ingredient> getAllIngredients() {
    return (List<Ingredient>) ingredientRepo.findAll();
  }
}
