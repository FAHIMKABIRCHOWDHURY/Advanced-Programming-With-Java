package com.repository;

import com.domain.History;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository

public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();

    }

    public boolean create(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    public User get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> UserQuery = session.createQuery("from User", User.class);
        return UserQuery.getResultList();
    }
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = get(id);
        if (user != null) {
            session.delete(user);
        }
    }

    public User Login(String gmail, String pass) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User where gmail = :gmail and pass = :pass ", User.class);
        userQuery.setParameter("gmail", gmail);
        userQuery.setParameter("pass", pass);

        return userQuery.getSingleResult();
    }
}

