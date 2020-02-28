package readerblog.mates.readerblog.services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import readerblog.mates.readerblog.entities.Category;
import readerblog.mates.readerblog.repositories.CategoryRepository;
import readerblog.mates.readerblog.services.CategoryService;

import java.util.List;

/**
 * @author mzheldin@yandex.ru
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category findOne(Long id) {
        if (id != null)
            return categoryRepository.findById(id).get();
        return null;
    }

    @Override
    @Transactional
    public Category findOne(String name) {
        if (name != null)
            return categoryRepository.findByName(name);
        return null;
    }

    @Override
    @Transactional
    public Boolean changeName(String oldName, String newName) {
        if (oldName != null && newName != null)
            return categoryRepository.update(oldName, newName) > 0;
        return false;
    }

    @Override
    @Transactional
    public Category remove(Long id) {
        if (id != null && categoryRepository.findById(id).isPresent())
            return categoryRepository.removeById(id);
        return null;
    }

    @Override
    @Transactional
    public Category remove(String name) {
        if (name != null && categoryRepository.findByName(name) != null)
            return categoryRepository.removeByName(name);
        return null;
    }

    @Override
    @Transactional
    public Category save(Category category) {
        if (category != null)
            categoryRepository.save(category);
        return null;
    }
}
