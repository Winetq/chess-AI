package counters.black;

import abstraction.Counter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.Point;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

@Test
public class BlackKingTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter counter = new BlackKing(new Point(4, 3));
        assertTrue(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] getCorrectMoves() {
        return new Object[][]{
                {4, 2},
                {5, 2},
                {5, 3},
                {5, 4},
                {4, 4},
                {3, 4},
                {3, 3},
                {3, 2}
        };
    }

    @Test(dataProvider = "getIncorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y) {
        Counter counter = new BlackKing(new Point(4, 3));
        assertFalse(counter.isAllowedMove(new Point(x, y), null));
    }

    @DataProvider
    public static Object[][] getIncorrectMoves() {
        return new Object[][]{
                {4, 1},
                {6, 3},
                {4, 5},
                {2, 3},
                {2, 1},
                {6, 5},
                {2, 5},
                {6, 1}
        };
    }
}
