package sweetbook.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(unique = true, length = 30)
  private String name;

}
