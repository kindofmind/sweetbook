package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.Rating;
import sweetbook.entities.Recipe;
import sweetbook.entities.User;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
  Rating findByUserAndRecipe(User user, Recipe recipe);
}
