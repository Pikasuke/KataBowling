import org.example.Analyzer;
import org.example.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GammeTest {

    @Test
    void aGameAddFrameFromPins() {
        List<Frame> frames = new ArrayList<>();
        frames.add( Analyzer.extractFrame(List.of(5,5)));
        Assertions.assertEquals(List.of(new Frame( 2,1)).get( 0 ).score(),frames.get( 0 ).score());
    }
}
