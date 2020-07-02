package sweetbook.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sweetbook.entities.Recipe;
import sweetbook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

  @Autowired
  private RecipeRepository recipeRepository;

  public Page<Recipe> findAllByOrderByIdDesc(Pageable pageable) {
    return recipeRepository.findAllByOrderByIdDesc(pageable);
  }

  public Page<Recipe> findAllByKeyword(String keyword, Pageable pageable) {
   return recipeRepository.findDistinctByNameContainsIgnoreCaseOrCategoriesNameContainsIgnoreCaseOrCompositionsIngredientNameContainsIgnoreCaseOrUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCase(
       keyword, keyword, keyword, keyword, keyword, pageable);
   }

  public Page<Recipe> findAllByName(String recipeName, Pageable pageable) {
    return recipeRepository.findByNameContainsIgnoreCase(recipeName, pageable);
  }

  public Page<Recipe> findAllByCategory(String categoryName, Pageable pageable) {
    return recipeRepository.findByCategoriesNameContainsIgnoreCase(categoryName, pageable);
  }

  public Page<Recipe> findAllByUser(String firstName, String lastName, Pageable pageable) {
    return recipeRepository.findByUserFirstNameLikeIgnoreCaseOrUserLastNameLikeIgnoreCase(firstName.trim(), lastName.trim(), pageable);
  }

  public Page<Recipe> findSorted(String categoryName, Pageable pageable) {
    return recipeRepository.findByCategoriesNameContainsIgnoreCase(categoryName, pageable);
  }

  public Page<Recipe> findAllByIngredient(String ingredientName, Pageable pageable) {
    return recipeRepository.findByCompositionsIngredientNameContainsIgnoreCase(ingredientName, pageable);
  }

  public List<Recipe> findAll() {
    return (List<Recipe>) recipeRepository.findAll();
  }

  public Recipe findById(int id) {
    return recipeRepository.findById(id).get();
  }

  public void save(Recipe recipe) {
    recipeRepository.save(recipe);
  }

  public void delete(int id) {
    recipeRepository.deleteById(id);
  }

}

