package sweetbook.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import sweetbook.entities.Recipe;


public interface RecipePagingRepository extends PagingAndSortingRepository<Recipe, Integer> {

}
