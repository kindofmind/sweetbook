package sweetbook.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sweetbook.entities.Recipe;
import sweetbook.repositories.RecipePagingRepository;
import sweetbook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

  @Autowired
  private RecipeRepository recipeRepository;

  @Autowired
  private RecipePagingRepository recipePagingRepository;

  public Page<Recipe> findAll(Pageable pageable) {
    return recipePagingRepository.findAll(pageable);
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

