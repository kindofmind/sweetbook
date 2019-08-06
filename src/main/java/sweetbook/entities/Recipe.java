package sweetbook.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  private String name;

/*
  private String desctiption;

  private String algorithm;

  @ManyToOne
  private User user;
*/


  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Category> categories;

 /*
  @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
  private Set<Composition> compositions;

  @OneToMany(cascade = CascadeType.ALL, mappedBy="recipe", orphanRemoval=true)
  private Set<Rating> rating;


  */

  public Recipe() {
  }

  public Recipe(int id, User user, Set<Category> categories, Set<Composition> compositions, String name, String desctiption, String algorithm, Set<Rating> rating) {
    this.id = id;
  //  this.user = user;
    this.categories = categories;
   // this.compositions = compositions;
    this.name = name;
   // this.desctiption = desctiption;
    //this.algorithm = algorithm;
    // this.rating = rating;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
/*

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
*/

  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }
/*

  public Set<Composition> getCompositions() {
    return compositions;
  }

  public void setCompositions(Set<Composition> compositions) {
    this.compositions = compositions;
  }
*/

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

/*  public String getDesctiption() {
    return desctiption;
  }

  public void setDesctiption(String desctiption) {
    this.desctiption = desctiption;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public Set<Rating> getRating() {
    return rating;
  }

  public void setRating(Set<Rating> rating) {
    this.rating = rating;
  }*/
}
