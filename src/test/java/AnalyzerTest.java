import org.example.Analyzer;
import org.example.Frame;
import org.example.Spare;
import org.example.Strike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnalyzerTest {

    @Test
    public void givenAListOfThrows641023CreateASpareWithScore20() {
        Frame result = Analyzer.extractFrame(List.of(6,4,10,2,3));
        Assertions.assertEquals(Spare.class,result.getClass());
        Assertions.assertEquals(20,result.frameScore());
    }

    @Test
    public void givenAListOfThrows55327CreateASpareWithScore13() {
        Frame result = Analyzer.extractFrame(List.of(5,5,3,2,7));
        Assertions.assertEquals(Spare.class,result.getClass());
        Assertions.assertEquals(13,result.frameScore());
    }

    @Test
    public void givenAListOfThrows54327CreateAFrameWithScore9() {
        Frame result = Analyzer.extractFrame(List.of(5,4,3,2,7));
        Assertions.assertEquals(Frame.class,result.getClass());
        Assertions.assertEquals(9,result.frameScore());
    }
    @Test
    public void givenAnImcompleteSpare64givesAScoreOf10() {
        Frame result = Analyzer.extractFrame(List.of(6,4));
        Assertions.assertEquals(Spare.class,result.getClass());
        Assertions.assertEquals(10,result.frameScore());
    }

    @Test
    public void givenAnIncompleteFrameGivesAIncompleteScore() {
        Frame result = Analyzer.extractFrame(List.of(6));
        Assertions.assertEquals(Frame.class,result.getClass());
        Assertions.assertEquals(6,result.frameScore());
    }

    @Test
    public void givenA1023StrikeGivesAScoreOf15() {
        Frame result = Analyzer.extractFrame(List.of(10,2,3));
        Assertions.assertEquals(Strike.class,result.getClass());
        Assertions.assertEquals(15,result.frameScore());
    }

    @Test
    public void givenAIncompleteStrike102GivesAScoreOf12() {
        Frame result = Analyzer.extractFrame(List.of(10,2));
        Assertions.assertEquals(Strike.class,result.getClass());
        Assertions.assertEquals(12,result.frameScore());
    }

    @Test
    public void givenAIncompleteStrike10GivesAScoreOf10() {
        Frame result = Analyzer.extractFrame(List.of( 10));
        Assertions.assertEquals(Strike.class,result.getClass());
        Assertions.assertEquals(10,result.frameScore());
    }

    @Test
    public void givenAnStrikeGiveAThrowingTakenOf1(){
        Assertions.assertEquals(1, Analyzer.throwsTaken(Analyzer.extractFrame(List.of(10,3,5,3))));
    }

    @Test
    public void givenAnSPareGiveAThrowingTakenOf2(){
        Assertions.assertEquals(2, Analyzer.throwsTaken(Analyzer.extractFrame(List.of(7,3,5,3))));
    }

    @Test
    public void givenAFrameGiveAThrowingTakenOf2(){
        Assertions.assertEquals(2, Analyzer.throwsTaken(Analyzer.extractFrame(List.of(7,1,5,3))));
    }
}
