package my.sweetbook.is.Entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredient {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String name;

  public Ingredient() {
  }

  public Ingredient(int id, String name) {
    this.id = id;
    this.name = name;}

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


