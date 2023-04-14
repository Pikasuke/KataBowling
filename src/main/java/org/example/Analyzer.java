package org.example;

import java.util.List;

public class Analyzer {


    public static Frame extractFrame(List<Integer> shoots) {
        if (shoots.size() > 1) {
            if (shoots.get(0) == 10 ) {
                return createStrike(shoots);
            }
            if (shoots.get(0) + shoots.get(1) == 10) {
                return createSpare(shoots);
            }
            return new Frame(shoots.get(0) + shoots.get(1));
        } else if (shoots.get(0) == 10 ) {
            return new Strike(10);
        }
        return new Frame(shoots.get(0));
    }

    private static Strike createStrike(List<Integer> shoots) {
        if (shoots.size() > 2){
            return new Strike(10 + shoots.get(1) + shoots.get(2));
        }
        return new Strike(shoots.get(0) + shoots.get(1));
    }

    private static Spare createSpare(List<Integer> shoots) {
        if (shoots.size() > 2) {
            return new Spare(10 + shoots.get(2));
        } else {
            return new Spare(10);
        }
    }

    public static int throwsTaken(Frame frame) {
        if (frame.getClass() == Strike.class)
            return 1;
        return 2;
    }
}
