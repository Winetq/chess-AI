package counters;

import abstraction.Counter;
import counters.black.BlackPawn;
import counters.white.WhiteKing;
import counters.white.WhitePawn;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class PawnTest {

    // BlackPawn

    @Test(dataProvider = "getCorrectMovesForBlackPawn")
    public void isAllowedMove_choosingCorrectMovesForBlackPawn_shouldBeTrue(int x, int y, Counter attackedCounter) {
        Counter counter = new BlackPawn(new Point(4, 1));
        assertTrue(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getCorrectMovesForBlackPawn() {
        return new Object[][]{
                {4, 2, null},
                {4, 3, null},
                {3, 2, new WhiteKing(new Point(3, 2))},
                {5, 2, new WhiteKing(new Point(5, 2))}
        };
    }

    @Test(dataProvider = "getIncorrectMovesForBlackPawn")
    public void isAllowedMove_choosingIncorrectMovesForBlackPawn_shouldBeFalse(int x, int y, Counter attackedCounter) {
        Counter counter = new BlackPawn(new Point(4, 1));
        assertFalse(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getIncorrectMovesForBlackPawn() {
        return new Object[][]{
                {3, 2, null},
                {5, 2, null},
                {4, 2, new WhiteKing(new Point(4, 2))},
                {4, 3, new WhiteKing(new Point(4, 3))},
                {4, 0, null},
                {4, 0, new WhiteKing(new Point(4, 0))}
        };
    }

    // WhitePawn

    @Test(dataProvider = "getCorrectMovesForWhitePawn")
    public void isAllowedMove_choosingCorrectMovesForWhitePawn_shouldBeTrue(int x, int y, Counter attackedCounter) {
        Counter counter = new WhitePawn(new Point(4, 6));
        assertTrue(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getCorrectMovesForWhitePawn() {
        return new Object[][]{
                {4, 5, null},
                {4, 4, null},
                {3, 5, new WhiteKing(new Point(3, 5))},
                {5, 5, new WhiteKing(new Point(5, 5))}
        };
    }

    @Test(dataProvider = "getIncorrectMovesForWhitePawn")
    public void isAllowedMove_choosingIncorrectMovesForWhitePawn_shouldBeFalse(int x, int y, Counter attackedCounter) {
        Counter counter = new WhitePawn(new Point(4, 6));
        assertFalse(counter.isAllowedMove(new Point(x, y), attackedCounter));
    }

    @DataProvider
    public static Object[][] getIncorrectMovesForWhitePawn() {
        return new Object[][]{
                {3, 5, null},
                {5, 5, null},
                {4, 5, new WhiteKing(new Point(4, 5))},
                {4, 4, new WhiteKing(new Point(4, 4))},
                {4, 7, null},
                {4, 7, new WhiteKing(new Point(4, 7))}
        };
    }
}

