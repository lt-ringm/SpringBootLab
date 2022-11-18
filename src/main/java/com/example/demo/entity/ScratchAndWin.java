package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "grattaevinci")
public class ScratchAndWin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Identifier

    private Integer number; // Scratch&win number

    private Boolean is_winner; // Whether it's a winning or losing scratch&win

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
