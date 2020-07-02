package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.Rating;
import sweetbook.entities.Recipe;
import sweetbook.entities.User;
import sweetbook.repositories.RatingRepository;

@Service
public class RatingService {

  @Autowired
  private RatingRepository ratingRepository;

  public Rating findRatingByUserAndRecipe(User user, Recipe recipe) {
   return ratingRepository.findByUserAndRecipe(user, recipe);
  }

  public void saveRating(Rating rating) {
    ratingRepository.save(rating);
  }

}
