package counters.black;

import abstraction.Counter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.Point;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

@Test
public class BlackBishopTest {

    @Test(dataProvider = "correctMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter counter = new BlackBishop(new Point(4, 3));
        assertTrue(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] correctMoves() {
        return new Object[][]{
                {3, 4},
                {2, 5},
                {1, 6},
                {0, 7},
                {5, 4},
                {6, 5},
                {7, 6},
                {3, 2},
                {2, 1},
                {1, 0},
                {5, 2},
                {6, 1},
                {7, 0}
        };
    }

    @Test(dataProvider = "incorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y) {
        Counter counter = new BlackBishop(new Point(4, 3));
        assertFalse(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] incorrectMoves() {
        return new Object[][]{
                {4, 2},
                {5, 3},
                {4, 4},
                {3, 3},
                {0, 0},
                {7, 7},
                {7, 1},
                {1, 7}
        };
    }
}