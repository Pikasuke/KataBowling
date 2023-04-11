package org.example;

public class Spare extends Frame{

    public Frame frame;

    public Spare(int shoot1, int shoot2, Frame frame) {
        super(shoot1, shoot2);
        this.frame = frame;
    }

    @Override
    public int score() {
        return super.score()+ frame.getBonus();
    }
}
