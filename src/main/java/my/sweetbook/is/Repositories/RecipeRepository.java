package my.sweetbook.is.Repositories;


import my.sweetbook.is.Entities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
