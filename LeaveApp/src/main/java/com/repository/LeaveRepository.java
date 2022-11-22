package com.repository;

import com.domain.Leaves;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.List;
public class LeaveRepository {
    private SessionFactory sessionFactory;

    public LeaveRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Leaves> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Leaves> leaveApplicationQuery = session.createQuery("from Leaves", Leaves.class);
        return leaveApplicationQuery.getResultList();
    }
    public boolean create(Leaves leaves) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(leaves);
        return true;
    }
}
