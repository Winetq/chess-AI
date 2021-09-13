package counters.black;

import abstraction.Counter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.Point;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

@Test
public class BlackRookTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter counter = new BlackRook(new Point(4, 3));
        assertTrue(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] getCorrectMoves() {
        return new Object[][]{
                {4, 2},
                {4, 1},
                {4, 0},
                {4, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {5, 3},
                {6, 3},
                {7, 3},
                {3, 3},
                {2, 3},
                {1, 3},
                {0, 3}
        };
    }

    @Test(dataProvider = "getIncorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y) {
        Counter counter = new BlackRook(new Point(4, 3));
        assertFalse(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] getIncorrectMoves() {
        return new Object[][]{
                {3, 2},
                {5, 2},
                {5, 4},
                {3, 4},
                {3, 1},
                {5, 1},
                {6, 2},
                {6, 4},
                {5, 5},
                {3, 5},
                {2, 4},
                {2, 2}
        };
    }
}

