package com.service;

import com.domain.Leaves;
import com.repository.LeaveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
@Service
@Transactional
public class LeaveApplicationService {
    private LeaveRepository leaveRepository;

    public LeaveApplicationService(LeaveRepository lr) {
        this.leaveRepository = lr;
    }

    @Transactional
    public boolean insert(Leaves leave1) throws SQLException {
        leave1.setFromLeaveDate(leave1.getFromLeaveDate());
        leave1.setToLeaveDate(leave1.getToLeaveDate());
        leave1.setReason(leave1.getReason());
        return leaveRepository.create(leave1);
    }
}
