package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sweetbook.entities.Category;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  List<Category> findByNameContainsIgnoreCase (String name);

  Category findByNameIgnoreCase (String name);

  boolean existsByNameIgnoreCase (String name);
}
