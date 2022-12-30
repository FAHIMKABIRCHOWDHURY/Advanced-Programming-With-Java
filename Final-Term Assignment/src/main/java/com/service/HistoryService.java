package com.service;

import com.domain.User;
import com.domain.History;
import com.repository.UserRepository;
import com.repository.HistoryRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HistoryService {
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
    @Transactional

    public boolean insert(History Huser) throws SQLException {
        Huser.setUserId(Huser.getUserId());
        Huser.setTax(Huser.getTax());
        Huser.setTotax(Huser.getTotax());
        return historyRepository.create(Huser);
    }
    @Transactional(readOnly = true)
    public History get(Long id) {
        return HistoryRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<History> getAll() {
        return HistoryRepository.getAll();
    }

    public List<History> getHistoryById(Long id) {
        return HistoryRepository.getHistoryById(id);
    }
    @Transactional
    public History update(History history) {
        return HistoryRepository.update(history);
    }

    @Transactional
    public void delete(Long id) {
        HistoryRepository.delete(id);
    }

    public List<History> loadHistoryById(Long id)  {
        History history = getHistoryById(id);
        if ( history == null) {
            return new ArrayList<>();
        }
        return  (history.getId(), history.getTax(), history.getTotax());
    }


}
