package sweetbook.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Category> categories;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Composition> compositions;

  private String name;

  private String description;

  private String algorithm;

  @ManyToOne
  private User user;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<Rating> rating;

  private int sumRating;

/*  public void updateRating(Rating oldRating, Rating newRating) throws Exception{
    if (oldRating == null) this.rating.add(newRating);
    else if (this.rating.contains(oldRating)) {
      this.rating.remove(oldRating);
      newRating.setId(oldRating.getId());
      this.rating.add(newRating);
    } else throw new RatingUpdateExceprion();
  }

  private class RatingUpdateExceprion extends Exception {
    public RatingUpdateExceprion() {
      super("Something went wrong during rating update!");
    }
  }*/
}
