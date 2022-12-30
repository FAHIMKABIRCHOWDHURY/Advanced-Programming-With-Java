package com.service;

import com.domain.History;
import com.domain.User;
import com.repository.HistoryRepository;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public boolean insert(User user) throws SQLException {
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPass(user.getPass());
        return userRepository.create(user);
    }
    @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepository.get(id);
    }
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return UserRepository.getAll();
    }



    @Transactional
    public User update(User user) {
        return UserRepository.update(User);
    }

    @Transactional
    public void delete(Long id) {
        UserRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public User login(String email,String pass) { return UserRepository.Login(email,pass); }
}
