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

  public Ingredient findByName(String name) {
    return ingredientRepository.findByNameIgnoreCase(name);
  }

  public List<Ingredient> findByKeyword(String name) {
    return ingredientRepository.findByNameContainsIgnoreCase(name);
  }

  public boolean existsByName(String name) {
    return ingredientRepository.existsByNameIgnoreCase(name.toLowerCase());
  }

}
