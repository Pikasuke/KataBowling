package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public static List<Frame> extractFrame(List<Integer> shoots) {
        List<Frame> frames = new ArrayList<>();
        int frameIndex = 0;
        if (shoots.size() == 21) {
            frames.add(createLastFrame(shoots));
            for (int i = shoots.size()-4; i > 0 ; i = i-2) {
                createRightFrames(shoots, frames, frameIndex, i);
                frameIndex++;
            }
        } else {
            for (int i = shoots.size() - 1; i > 0; i = i-2) {
                createRightFrames(shoots, frames, frameIndex, i);
                frameIndex++;
            }
        }
        Collections.reverse(frames);
        return frames;
    }

    private static void createRightFrames(List<Integer> shoots, List<Frame> frames, int frameIndex, int i) {
        if (isStrike(shoots, i)) {
            frames.add(createStrike(shoots, frames, frameIndex, i));
        }
        else if (isSpare(shoots, i)) {
                frames.add(createSpare(shoots, frames, frameIndex, i));
        }
        else {
            frames.add(createFrame(shoots, i));
            }
    }

    private static LastFrame createLastFrame(List<Integer> shoots) {
        return new LastFrame(shoots.get(18), shoots.get(19), shoots.get(20));
    }

    private static boolean isStrike(List<Integer> shoots, int i) {
        return shoots.get(i) == 0 && shoots.get(i - 1) == 10;
    }

    private static Frame createStrike(List<Integer> shoots, List<Frame> frames, int frameIndex, int i) {
        return new Strike(shoots.get(i -1), shoots.get(i), frames.get(frameIndex));
    }

    private static boolean isSpare(List<Integer> shoots, int i) {
        return shoots.get(i) + shoots.get(i - 1) == 10;
    }

    private static Frame createSpare(List<Integer> shoots, List<Frame> frames, int frameIndex, int i) {
        return new Spare(shoots.get(i -1), shoots.get(i), frames.get(frameIndex));
    }

    private static Frame createFrame(List<Integer> shoots, int i) {
        return new Frame(shoots.get(i -1), shoots.get(i));
    }


    public static int calculateTotalScore(List<Frame> frames) {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.score();
        }
        return totalScore;
    }
}
