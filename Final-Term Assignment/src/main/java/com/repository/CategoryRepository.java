package com.repository;
import com.domain.Category;
import com.domain.History;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class CategoryRepository {

    private SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean create(Category category) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        return true;
    }

    public Category get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> CategoryQuery = session.createQuery("from Category", Category.class);
        return CategoryQuery.getResultList();
    }




    public Category update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        return category;
    }

    public void delete(String cname) {
        Session session = sessionFactory.getCurrentSession();
        Category category = get(cname);
        if (category != null) {
            session.delete(category);
        }
    }
    public float getPercentage(String Category) {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> categoryQuery = session.createQuery("from User Select percentage where CategoryName = :ategory", Category.class);
        categoryQuery.setParameter("CategoryName", Category);
        return categoryQuery.getSingleResult().getPercentage();
    }
}
