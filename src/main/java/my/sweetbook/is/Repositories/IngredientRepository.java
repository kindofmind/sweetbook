package my.sweetbook.is.Repositories;


import my.sweetbook.is.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
