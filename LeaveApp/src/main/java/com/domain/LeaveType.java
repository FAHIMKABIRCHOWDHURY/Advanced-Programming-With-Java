package com.domain;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "LeaveType")
public class LeaveType {
    @ManyToOne
    @JoinColumn(name = "leaveId")
    private Leaves leavId;
    @ManyToOne
    @JoinColumn(name = "leaveId")
    private Leaves total;
    private String type;
    @Id
    private Long id;
    public Leaves getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
