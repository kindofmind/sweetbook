package sweetbook.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

  Page<Recipe> findAllByOrderByIdDesc(Pageable pageable);

  Page<Recipe> findByNameContainsIgnoreCaseOrderByIdDesc(String categoryName, Pageable pageable);

  Page<Recipe> findByCategoriesNameContainsIgnoreCaseOrderByIdDesc(String categoryName, Pageable pageable);

  Page<Recipe> findByCompositionsIngredientNameContainsIgnoreCaseOrderByIdDesc(String ingredientName, Pageable pageable);

  Page<Recipe> findByUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCaseOrderByIdDesc(String firstName, String lastName, Pageable pageable);

  Page<Recipe> findDistinctByNameContainsIgnoreCaseOrCategoriesNameContainsIgnoreCaseOrCompositionsIngredientNameContainsIgnoreCaseOrUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCaseOrderByIdDesc(String recipeName,
                                                                                                                                                                                     String categoryName,
                                                                                                                                                                                     String ingredientName,
                                                                                                                                                                                     String firstName,
                                                                                                                                                                                     String lastName,
                                                                                                                                                                                     Pageable pageable);
}
