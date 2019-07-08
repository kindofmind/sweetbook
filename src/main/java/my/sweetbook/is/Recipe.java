package my.sweetbook.is;

import javax.persistence.Entity;

@Entity
public class Recipe {
  private String id;
  private String name;
  private String desctiption;
  private String ingredients;
   

  public String getId() {
    return id;
  }

  public Recipe() {
  }

  public Recipe(String id, String name, String desctiption) {
    super();
    this.id = id;
    this.name = name;
    this.desctiption = desctiption;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesctiption() {
    return desctiption;
  }

  public void setDesctiption(String desctiption) {
    this.desctiption = desctiption;
  }
}
