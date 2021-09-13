package counters.black;

import abstraction.Counter;
import counters.white.WhiteKing;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.Point;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

@Test
public class BlackPawnTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y, Counter attackedCounter) {
        Counter counter = new BlackPawn(new Point(4, 1));
        assertTrue(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getCorrectMoves() {
        return new Object[][]{
                {4, 2, null},
                {4, 3, null},
                {3, 2, new WhiteKing(new Point(3, 2))},
                {5, 2, new WhiteKing(new Point(5, 2))}
        };
    }

    @Test(dataProvider = "getIncorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y, Counter attackedCounter) {
        Counter counter = new BlackPawn(new Point(4, 1));
        assertFalse(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getIncorrectMoves() {
        return new Object[][]{
                {3, 2, null},
                {5, 2, null},
                {4, 2, new WhiteKing(new Point(4, 2))},
                {4, 3, new WhiteKing(new Point(4, 3))},
                {4, 0, null},
                {4, 0, new WhiteKing(new Point(4, 0))}
        };
    }
}

