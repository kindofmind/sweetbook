package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
