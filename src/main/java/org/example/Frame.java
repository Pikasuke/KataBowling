package org.example;

public class Frame {

    private int shoot1;
    private int shoot2;

    public Frame(int shoot1, int shoot2) {
        this.shoot1 = shoot1;
        this.shoot2 = shoot2;
    }

    public int score() {
        return shoot1 + shoot2;
    }
    protected int getBonus() {
        return shoot1;
    }
    protected int getStrikeBonus() {
        return getBonus()+shoot2;
    }
}
