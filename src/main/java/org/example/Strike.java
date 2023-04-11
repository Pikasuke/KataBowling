package org.example;

public class Strike extends Frame {

    private Frame frame;

    public Strike(int shoot1, Frame frame) {
        super(shoot1, 0);
        this.frame = frame;
    }
    @Override
    public int score() {
        return super.score()+ frame.getStrikeBonus();
    }

}
