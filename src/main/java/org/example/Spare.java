package org.example;

import java.util.Objects;

public class Spare extends Frame{

    public Frame frame;

    public Spare(int shoot1, int shoot2, Frame frame) {
        super(shoot1, shoot2);
        this.frame = frame;
    }

    public Spare(Integer score) {
        super(score);
    }



    @Override
    public int score() {
        return super.score()+ frame.getBonus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spare spare = (Spare) o;
        return Objects.equals(frame, spare.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), frame);
    }

    @Override
    public String toString() {
        return "Spare{ score " + super.score()+ "  bonusss   "+ super.getBonus() + "}";
    }
}
