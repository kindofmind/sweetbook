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

  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }

  public List<Category> liveSearch(String name) {
    return categoryRepository.findByNameContainsIgnoreCase(name);
  }

  public boolean existsByName(String name) {
    return categoryRepository.existsByNameIgnoreCase(name.toLowerCase());
  }

  public Category findByName(String name) {
    return categoryRepository.findByNameIgnoreCase(name);
  }

  public Category findById(int id) {
    return categoryRepository.getOne(id);
  }
}
