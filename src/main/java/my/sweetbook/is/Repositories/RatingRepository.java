package my.sweetbook.is.Repositories;


import my.sweetbook.is.Entities.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
