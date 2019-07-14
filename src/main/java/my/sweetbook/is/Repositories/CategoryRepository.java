package my.sweetbook.is.Repositories;


import my.sweetbook.is.Entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
