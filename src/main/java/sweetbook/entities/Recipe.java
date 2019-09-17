package sweetbook.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Category> categories;

  @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
  private Set<Composition> compositions;

  private String name;

  private String description;

  private String algorithm;

  @ManyToOne
  private User user;

  @OneToMany(cascade = CascadeType.ALL, mappedBy="recipe", orphanRemoval=true)
  private Set<Rating> rating;

  public Recipe() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

  public Set<Composition> getCompositions() {
    return compositions;
  }

  public void setCompositions(Set<Composition> compositions) {
    this.compositions = compositions;
  }

  public User getUser() {
    return user;
  }
}
