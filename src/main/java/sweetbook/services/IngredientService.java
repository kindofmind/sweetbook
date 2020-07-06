package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.Composition;
import sweetbook.entities.Ingredient;
import sweetbook.repositories.IngredientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public Set<Composition> processUniqueIngredient(Set<Composition> inCompositions) {
    Set<Composition> outCompositions = new HashSet<Composition>();
    if (inCompositions.size() > 0) {
      for (Composition composition : inCompositions) {
        if (existsByName(composition.getIngredient().getName()))
          composition.setIngredient(findByName(composition.getIngredient().getName()));
        outCompositions.add(composition);
      }
    }
    return outCompositions;
  }

}
