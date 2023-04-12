import org.example.Frame;
import org.example.LastFrame;
import org.example.Spare;
import org.example.Strike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingTest {

    @Test
    public void aFrame35ShouldCalculateItsScore() {
        Frame frame = new Frame(3,5);
        Assertions.assertEquals(3+5, frame.score());
    }
    @Test
    public void aFrame43ShouldCalculateItsScore() {
        Frame frame = new Frame(4,3);
        Assertions.assertEquals(4+3, frame.score());
    }
    @Test
    public void aSpare3ShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(3,0);
        Spare spare = new Spare(4,6, frame);
        //Act
        int expected = spare.score();
        //Assert
        Assertions.assertEquals(10+3, expected);
    }
    @Test
    public void aSpare7ShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(7,0);
        Spare spare = new Spare(4,6, frame);
        //Act
        int expected = spare.score();
        //Assert
        Assertions.assertEquals(10+7, expected);
    }
    @Test
    public void aStrikeShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(5,1);
        Strike strike = new Strike(10,0, frame);
        //Act
        int result = strike.score();
        //Assert
        Assertions.assertEquals(10+5+1, result);
    }
    @Test
    public void aStrikeAndSpareShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(5,1);
        Spare spare = new Spare(5,5,frame);
        Strike strike = new Strike(10,0, spare);
        //Act
        int result = strike.score();
        //Assert
        Assertions.assertEquals(10+5+5, result);
    }
    @Test
    public void aDoubleStrikeeShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(5,1);
        Strike next = new Strike(10, 0,frame);
        Strike strike = new Strike(10,0, next);
        //Act
        int result = strike.score();
        //Assert
        Assertions.assertEquals(10+10+5, result);
    }
    @Test
    public void aQuadrupleStrikeAndASpareShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(2,5);
        Frame spare = new Spare(8,2,frame);
        Frame first = new Strike(10,0, spare);
        Frame second = new Strike(10,0, first);
        Frame third = new Strike(10,0, second);
        Frame strike = new Strike(10,0, third);
        //Act
        int actual = strike.score();
        //Assert
        Assertions.assertEquals(10+10+10, actual);
        Assertions.assertEquals(10+10+10, third.score());
        Assertions.assertEquals(10+10+8, second.score());
        Assertions.assertEquals(10+8+2, first.score());
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
