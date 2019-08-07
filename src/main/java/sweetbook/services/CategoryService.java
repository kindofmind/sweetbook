package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.Category;
import sweetbook.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category findByName(String name) {
    return categoryRepository.findByNameIgnoreCase(name);
  }

  public List<Category> findByKeyword(String name) {
    return categoryRepository.findByNameContainsIgnoreCase(name);
  }

  public boolean existsByName(String name) {
    return categoryRepository.existsByNameIgnoreCase(name.toLowerCase());
  }
}
