import org.example.Frame;
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
        Strike strike = new Strike(10, frame);
        //Act
        int expected = strike.score();
        //Assert
        Assertions.assertEquals(10+5+1, expected);
    }
    @Test
    public void aStrikeAndSpareShouldCalculateItsScore() {
        //Arrange
        Frame frame = new Frame(5,1);
        Spare spare = new Spare(5,5,frame);
        Strike strike = new Strike(10, spare);
        //Act
        int expected = strike.score();
        //Assert
        Assertions.assertEquals(10+5+5, expected);
    }

}
