package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrattaEVinci {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Identifier

    private Integer number; // Ticket number

    private Boolean is_winner; // Whether it's a winning or losing ticket

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIs_winner() {
        return is_winner;
    }

    public void setIs_winner(Boolean is_winner) {
        this.is_winner = is_winner;
    }
}
