package com.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "History")

public class History {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "userId")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @NotNull
    @Column(name = "Tax")
    private float Tax;

    public float getTax() {
        return Tax;
    }

    public void setTax(float Tax) {
        this.Tax = Tax;
    }


    @NotNull
    @Column(name = "Totax")
    private float Totax;

    public float getTotax() {
        return Totax;
    }

    public void setTotax(float Totax) {
        this.Totax = Totax;
    }

}
