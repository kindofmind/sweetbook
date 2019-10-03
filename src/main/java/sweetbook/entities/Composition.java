package sweetbook.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Composition {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Ingredient ingredient;

  private String count;

}
