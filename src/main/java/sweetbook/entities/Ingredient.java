package sweetbook.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

}


