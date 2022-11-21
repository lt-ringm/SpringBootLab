package com.example.demo.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "scratchandwin")
public class ScratchAndWin {
    @Id
    @Column(nullable = false)
    @Range(max=9999)
    private Integer id; // Identifier - the number on the back of the scratch&win

    // Numbers on the scratch&win
    @Column(nullable = false)
    @Range(min=1, max=10)
    private Integer num1;

    @Column(nullable = false)
    @Range(min=1, max=10)
    private Integer num2;

    @Column(nullable = false)
    @Range(min=1, max=10)
    private Integer num3;

    @Column(nullable = false)
    @Range(min=1, max=10)
    private Integer num4;

    @Column(nullable = false)
    @Range(min=1, max=10)
    private Integer winner; // Winner number

    @Column(nullable = false)
    private double prize; // How much you can win

    @Column(nullable = false)
    private boolean bought; // Whether it has been bought

    // GETTERS AND SETTERS ---------------------------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public Integer getNum4() {
        return num4;
    }

    public void setNum4(Integer num4) {
        this.num4 = num4;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
