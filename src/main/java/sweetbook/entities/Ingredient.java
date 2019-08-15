package sweetbook.entities;

import javax.persistence.*;

@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  //@Column(unique = true, length = 30, nullable = false)
  private String name;

  public Ingredient() {
  }

  public Ingredient(String name) {
    this.name = name;
  }

  public Ingredient(int id, String name) {
    this.id = id;
    this.name = name;
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

  }


