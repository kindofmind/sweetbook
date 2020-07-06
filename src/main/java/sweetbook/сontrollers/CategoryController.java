package sweetbook.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sweetbook.entities.Category;
import sweetbook.services.CategoryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping("{name}")
  public List<Category> findByKeyword(@PathVariable String name) {
    return categoryService.findByKeyword(name);
  }

}
