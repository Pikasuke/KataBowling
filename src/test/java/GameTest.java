import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void aGutterGameReturnAListOf10Frames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame(0, 0);
            frames.add(frame);
        }
        Assertions.assertEquals(frames.size(), Game.extractFrame(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).size());
        Assertions.assertEquals(frames, Game.extractFrame(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
    }

    @Test
    public void anBonusLastFrameGameReturnAListOf9FramesAndBonus() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new Frame(0, 0);
            frames.add(frame);
        }
        frames.add(new LastFrame(0, 1, 2));
        Assertions.assertEquals(21, List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2).size());
        Assertions.assertEquals(frames.get(9), new LastFrame(0, 1, 2));
        Assertions.assertEquals(frames, Game.extractFrame(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2)));
    }

    @Test
    public void anAverageFrameGameScoreHisSumOfShoots() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new Frame(0, 9);
            frames.add(frame);
        }
        List<Integer> matchPoints = List.of(0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 3, 2);
        frames.add(new Frame(3, 2));
        Assertions.assertEquals(frames.get(9), new Frame(3, 2));
        Assertions.assertEquals(frames, Game.extractFrame(matchPoints));
        Assertions.assertEquals(matchPoints.stream().mapToInt(Integer::intValue).sum(), Game.calculateTotalScore(Game.extractFrame(matchPoints)));
    }

    @Test
    public void a12StrikeShouldScore300() {
        List<Frame> frames = new ArrayList<>();
        LastFrame lastFrame = new LastFrame(10, 10, 10);
        Frame nine = new Strike(10, 0, lastFrame);
        Frame eight = new Strike(10, 0, nine);
        Frame seven = new Strike(10, 0, eight);
        Frame six = new Strike(10, 0, seven);
        Frame five = new Strike(10, 0, six);
        Frame four = new Strike(10, 0, five);
        Frame three = new Strike(10, 0, four);
        Frame two = new Strike(10, 0, three);
        Frame one = new Strike(10, 0, two);
        frames.add(one);
        frames.add(two);
        frames.add(three);
        frames.add(four);
        frames.add(five);
        frames.add(six);
        frames.add(seven);
        frames.add(eight);
        frames.add(nine);
        frames.add(lastFrame);
        System.out.println("totot" + frames.get(3).toString());
        System.out.println("totot" + frames.get(3).score());
        List<Integer> matchPoints = List.of(10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10);
        Assertions.assertEquals(frames.get(9), new LastFrame(10, 10, 10));
        Assertions.assertEquals(30, one.score());
        Assertions.assertEquals(30, Game.extractFrame(matchPoints).get(0).score());
        Assertions.assertEquals(frames.get(2), Game.extractFrame(matchPoints).get(2));
        Assertions.assertEquals(frames.get(0).toString(), Game.extractFrame(matchPoints).get(0).toString());
        Assertions.assertEquals(300, Game.calculateTotalScore(Game.extractFrame(matchPoints)));
        Assertions.assertEquals(frames, Game.extractFrame(matchPoints));
    }

    @Test
    public void aSpareGameShouldScoreWithBonus() {
        List<Frame> frames = new ArrayList<>();
        LastFrame lastFrame = new LastFrame(10, 4, 6);
        Frame nine = new Spare(4, 6, lastFrame);
        Frame eight = new Spare(3, 7, nine);
        Frame seven = new Spare(5, 5, eight);
        Frame six = new Spare(6, 4, seven);
        Frame five = new Spare(3, 7, six);
        Frame four = new Spare(2, 8, five);
        Frame three = new Spare(2, 8, four);
        Frame two = new Spare(9, 1, three);
        Frame one = new Spare(1, 9, two);
        frames.add(one);
        frames.add(two);
        frames.add(three);
        frames.add(four);
        frames.add(five);
        frames.add(six);
        frames.add(seven);
        frames.add(eight);
        frames.add(nine);
        frames.add(lastFrame);
        List<Integer> matchPoints = List.of(1, 9, 9, 1, 2, 8, 2, 8, 3, 7, 6, 4, 5, 5, 3, 7, 4, 6, 10, 4, 6);
        Assertions.assertEquals(frames.get(9), new LastFrame(10, 4, 6));
        Assertions.assertEquals(19, frames.get(0).score());
        Assertions.assertEquals(frames, Game.extractFrame(matchPoints));
        Assertions.assertEquals(frames.get(0), Game.extractFrame(matchPoints).get(0));
        Assertions.assertEquals(frames.get(1), Game.extractFrame(matchPoints).get(1));
        Assertions.assertEquals(frames.get(2), Game.extractFrame(matchPoints).get(2));
        Assertions.assertEquals(154, Game.calculateTotalScore(Game.extractFrame(matchPoints)));
    }

    @Test
    public void aNormalGameShouldScoreWithBonus() {
        List<Frame> frames = new ArrayList<>();
        LastFrame lastFrame = new LastFrame(3, 7, 6);
        Frame nine = new Frame(4, 3);
        Frame eight = new Frame(3, 5);
        Frame seven = new Spare(5, 5, eight);
        Frame six = new Spare(6, 4, seven);
        Frame five = new Strike(10, 0, six);
        Frame four = new Spare(2, 8, five);
        Frame three = new Frame(8, 1);
        Frame two = new Spare(9, 1, three);
        Frame one = new Spare(1, 9, two);
        frames.add(one);
        frames.add(two);
        frames.add(three);
        frames.add(four);
        frames.add(five);
        frames.add(six);
        frames.add(seven);
        frames.add(eight);
        frames.add(nine);
        frames.add(lastFrame);
        List<Integer> matchPoints = List.of(1, 9, 9, 1, 8, 1, 2, 8, 10, 0, 6, 4, 5, 5, 3, 5, 4, 3, 3, 7, 6);
        Assertions.assertEquals(frames.get(9), new LastFrame(3, 7, 6));
        Assertions.assertEquals(19, frames.get(0).score());
        Assertions.assertEquals(frames, Game.extractFrame(matchPoints));
        Assertions.assertEquals(frames.get(0), Game.extractFrame(matchPoints).get(0));
        Assertions.assertEquals(frames.get(1), Game.extractFrame(matchPoints).get(1));
        Assertions.assertEquals(frames.get(2), Game.extractFrame(matchPoints).get(2));
        Assertions.assertEquals(145, Game.calculateTotalScore(Game.extractFrame(matchPoints)));
    }
}
