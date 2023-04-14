import org.example.Frame;
import org.example.LastFrame;
import org.example.Spare;
import org.example.Strike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingTest {

    @Test
    public void aFrameWith3And5ShouldResultInAScoreOf8() {
        Frame frame = new Frame(3,5);
        Assertions.assertEquals(3+5, frame.score());
    }
    @Test
    public void aFrameWith4And3ShouldResultInAScoreOf7() {
        Frame frame = new Frame(4,3);
        Assertions.assertEquals(4+3, frame.score());
    }
    @Test
    public void aSpareWithA3AfterShouldCalculateItsScoreOf13() {
        Frame frame = new Frame(3,0);
        Spare spare = new Spare(4,6, frame);
        int expected = spare.score();
        Assertions.assertEquals(10+3, expected);
    }
    @Test
    public void aSpare7ShouldCalculateItsScore() {
        Frame frame = new Frame(7,0);
        Spare spare = new Spare(4,6, frame);
        int expected = spare.score();
        Assertions.assertEquals(10+7, expected);
    }
    @Test
    public void aStrikeShouldCalculateItsScore() {
        Frame frame = new Frame(5,1);
        Strike strike = new Strike(10,0, frame);
        int result = strike.score();
        Assertions.assertEquals(10+5+1, result);
    }
    @Test
    public void aStrikeAndSpareShouldCalculateItsScore() {
        Frame frame = new Frame(5,1);
        Spare spare = new Spare(5,5,frame);
        Strike strike = new Strike(10,0, spare);
        int result = strike.score();
        Assertions.assertEquals(10+5+5, result);
    }
    @Test
    public void aDoubleStrikeShouldCalculateItsScore() {
        Frame frame = new Frame(5,1);
        Strike next = new Strike(10, 0,frame);
        Strike strike = new Strike(10,0, next);

        int result = strike.score();

        Assertions.assertEquals(10+10+5, result);
    }

    @Test
    public void aQuadrupleStrikeAndASpareShouldUpToPointTheirsBonus() {
        Frame frame = new Frame(2,5);
        Frame spare = new Spare(8,2,frame);
        Frame fourth = new Strike(10,0, spare);
        Frame third = new Strike(10,0, fourth);
        Frame second = new Strike(10,0, third);
        Frame first = new Strike(10,0, second);

        Assertions.assertEquals(10+10+10, first.score());
        Assertions.assertEquals(10+10+10, second.score());
        Assertions.assertEquals(10+10+8, third.score());
        Assertions.assertEquals(10+8+2, fourth.score());
        Assertions.assertEquals(10+2, spare.score());
    }
    @Test
    public void aLastFrameshouldScoreNumberOfPins() {
        Frame last = new LastFrame(3,4,0);
        Assertions.assertEquals(7 , last.score());
    }
    @Test
    public void aLastSpareShouldScoreNumberOfPins() {
        Frame last = new LastFrame(3,7,3);
        Assertions.assertEquals(13 , last.score());
    }
    @Test
    public void ThreeLastStrikeShouldScoreNumberOfPins() {
        Frame last = new LastFrame(10,10,10);
        Assertions.assertEquals(30 , last.score());
    }

}
