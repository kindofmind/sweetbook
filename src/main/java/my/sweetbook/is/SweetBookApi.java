package my.sweetbook.is;

import my.sweetbook.is.Entities.Category;
import my.sweetbook.is.Entities.Recipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SweetBookApi {

  public static void main(String[] args) {
    SpringApplication.run(SweetBookApi.class, args);
  }
}
