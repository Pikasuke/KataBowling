package org.example;

import java.util.Objects;

public class LastFrame extends Frame {

    public int shoot3;
    public LastFrame(int shoot1, int shoot2, int shoot3) {
        super(shoot1, shoot2);
        this.shoot3 = shoot3;
    }

    @Override
    public int score () {
        return super.score()+ shoot3 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LastFrame lastFrame = (LastFrame) o;
        return shoot3 == lastFrame.shoot3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shoot3);
    }

    @Override
    public String toString() {
        return "org.example.LastFrame { shoot3= " + shoot3 +
                '}';
    }
}
