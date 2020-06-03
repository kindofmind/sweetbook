package sweetbook.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

  Page<Recipe> findByCategoriesNameContainsIgnoreCase(String categoryName, Pageable pageable);

  Page<Recipe> findByNameContainsIgnoreCase(String categoryName, Pageable pageable);

  Page<Recipe> findByCompositionsIngredientNameContainsIgnoreCase(String ingredientName, Pageable pageable);

  Page<Recipe> findByUserUsernameOrUserFirstNameOrUserLastNameContainsIgnoreCase(String ingredientName, Pageable pageable);

  Page<Recipe> findByNameOrCategoriesNameOrCompositionsIngredientNameOrUserUsernameOrUserFirstNameOrUserLastNameContainsIgnoreCase(String keyword, Pageable pageable);

}
