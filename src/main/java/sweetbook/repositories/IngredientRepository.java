package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

  List<Ingredient> findByNameContainsIgnoreCase(String name);

  Ingredient findByNameIgnoreCase(String name);

  boolean existsByNameIgnoreCase(String name);
}
