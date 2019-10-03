package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Composition;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {
}
