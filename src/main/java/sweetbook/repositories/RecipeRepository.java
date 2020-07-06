package sweetbook.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

  Page<Recipe> findAllByOrderByIdDesc(Pageable pageable);

  Page<Recipe> findByNameContainsIgnoreCase(String categoryName, Pageable pageable);

  Page<Recipe> findByCategoriesNameContainsIgnoreCase(String categoryName, Pageable pageable);

  Page<Recipe> findByCompositionsIngredientNameContainsIgnoreCase(String ingredientName, Pageable pageable);

  Page<Recipe> findByUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCase(String firstName, String lastName, Pageable pageable);

  Page<Recipe> findDistinctByNameContainsIgnoreCaseOrCategoriesNameContainsIgnoreCaseOrCompositionsIngredientNameContainsIgnoreCaseOrUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCase(String recipeName,
                                                                                                                                                                                     String categoryName,
                                                                                                                                                                                     String ingredientName,
                                                                                                                                                                                     String firstName,
                                                                                                                                                                                     String lastName,
                                                                                                                                                                                     Pageable pageable);
}
