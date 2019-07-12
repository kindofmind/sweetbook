package User.Ingredient;

import my.sweetbook.is.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {

}
