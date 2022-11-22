package com.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leaves")
public class Leaves {
    @Id
    @Column(name = "Lid")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "Eid")
    public Employee Eid;
    public LocalDate Start;
    public LocalDate end;
    public int total;
    public  String reason;

    public void setFromLeaveDate(LocalDate start)
    {
        this.Start = Start;
    }

    public LocalDate getFromLeaveDate() {
        return Start;
    }

    public void setToLeaveDate(LocalDate end) {
        this.end = end;
    }

    public LocalDate getToLeaveDate() {
        return end;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
