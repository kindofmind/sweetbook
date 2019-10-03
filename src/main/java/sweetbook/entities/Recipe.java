package sweetbook.entities;

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
  private Set<Rating> rating;

}
