package sweetbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweetbook.entities.Category;
import sweetbook.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public Set<Category> processUniqueCategory(Set<Category> inCategories) {
    Set<Category> outCategories = new HashSet<Category>();
    if (inCategories.size() > 0) {
      for (Category category : inCategories) {
        if (existsByName(category.getName()))
          category = findByName(category.getName());
        outCategories.add(category);
      }
    }
    return outCategories;
  }

}
