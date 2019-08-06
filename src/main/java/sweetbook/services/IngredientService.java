package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.Ingredient;
import sweetbook.repositories.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

  @Autowired
  private IngredientRepository ingredientRepository;

  public List<Ingredient> findIngredient (String name) {
    return ingredientRepository.findByNameContainsIgnoreCase(name);
  }
}
