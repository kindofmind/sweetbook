package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sweetbook.services.RatingService;

@RestController
public class RatingController {

  @Autowired
  private RatingService ratingService;

}
