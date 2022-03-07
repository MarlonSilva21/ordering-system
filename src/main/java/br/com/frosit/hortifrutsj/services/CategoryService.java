package br.com.frosit.hortifrutsj.services;

import br.com.frosit.hortifrutsj.domain.Category;
import br.com.frosit.hortifrutsj.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CrudMethodsInterface<Category>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Category insert(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public Category update(Category obj, Long id) {
        Category entity = findById(id);
        updateDataCategory(entity, obj);
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    private static void updateDataCategory(Category entity, Category obj){
        entity.setName(obj.getName());
    }
}
