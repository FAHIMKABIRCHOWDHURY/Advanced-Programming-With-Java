package com.repository;
import com.domain.History;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class HistoryRepository {
    private SessionFactory sessionFactory;

    public HistoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean create(History Huser) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(Huser);
        return true;
    }

    public History get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(History.class, id);
    }

    public List<History> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<History> HistoryQuery = session.createQuery("from History", History.class);
        return HistoryQuery.getResultList();
    }



    public List <History> getHistoryById(Long uid) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> historyQuery = session.createQuery("from History where userId = :uid", User.class);
        historyQuery.setParameter("userId", uid);
        return historyQuery.getMaxResults();
    }
    public History update(History history) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(history);
        return history;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        History history = get(id);
        if (history != null) {
            session.delete(history);
        }
    }

}
