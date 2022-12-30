package com.service;
import com.domain.Category;
import com.domain.History;
import com.domain.User;
import com.repository.CategoryRepository;
import com.repository.HistoryRepository;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public boolean insert(Category category) throws SQLException {
        category.setCategoryName(category.getCategoryName());
        category.setPercentage(category.getPercentage());

        return categoryRepository.create(category);
    }
    @Transactional(readOnly = true)
    public Category get(String cname) {
        return CategoryRepository.get(cname);
    }

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return CategoryRepository.getAll();
    }


    @Transactional
    public Category update(Category category) {
        return CategoryRepository.update(category);
    }

    @Transactional
    public void delete(String cname) {
        CategoryRepository.delete(cname);
    }

    public static float getPercentage(String CategoryName) throws UsernameNotFoundException {
        Category category = new Category();
              category.getPercentage()=  CategoryService.getPercentage(CategoryName);
        if (category.getPercentage() == null) {
           return 0.0;
        }
        return category.getPercentage();
    }

}
