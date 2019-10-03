package sweetbook.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Recipe recipe;

  private int value;

}


