package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Composition;
import sweetbook.entities.Ingredient;
import sweetbook.entities.Recipe;

import java.util.List;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {
}
