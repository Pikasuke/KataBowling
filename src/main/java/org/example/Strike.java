package org.example;

import java.util.Objects;

public class Strike extends Frame {

    private Frame frame;

    public Strike(int shoot1, int shoot2, Frame frame) {
        super(shoot1, shoot2);
        this.frame = frame;
    }
    @Override
    public int score() {
        return super.score()+ frame.getStrikeBonus();
    }

    @Override
    public int getStrikeBonus() {
        return super.score()+ frame.getBonus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Strike strike = (Strike) o;
        return Objects.equals(frame, strike.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), frame);
    }

    @Override
    public String toString() {
        return "Strike{ " + frame.score() + "}";
    }
}
