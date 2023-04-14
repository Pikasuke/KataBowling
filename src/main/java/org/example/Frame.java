package org.example;

import java.util.List;
import java.util.Objects;

public class Frame {

    private Integer frameScore;
    private int shoot1;
    private int shoot2;
    public Frame(int shoot1, int shoot2) {
        this.shoot1 = shoot1;
        this.shoot2 = shoot2;
    }

    public Frame (int score) {
        this.frameScore = score;
    }
    public int score() {
        return shoot1 + shoot2;
    }
    protected int getBonus() {
        return shoot1;
    }
    protected int getStrikeBonus() {
        return shoot1 + shoot2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return shoot1 == frame.shoot1 && shoot2 == frame.shoot2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoot1, shoot2);
    }

    @Override
    public String toString() {
        return "Frame{"+ shoot1 + " " + shoot2 +"}";
    }

    public Integer frameScore() {
        return this.frameScore;
    }
}

