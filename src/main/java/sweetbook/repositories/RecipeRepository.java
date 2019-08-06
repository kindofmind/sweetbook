package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sweetbook.entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
