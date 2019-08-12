package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Composition;
import sweetbook.entities.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
  List<Composition> findCompositionsById (int id);
}
