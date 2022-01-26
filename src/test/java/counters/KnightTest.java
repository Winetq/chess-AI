package counters;

import abstraction.Counter;
import counters.black.BlackKnight;
import counters.white.WhiteKnight;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

@Test
public class KnightTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter blackKnight = new BlackKnight(new Point(4, 3));
        Counter whiteKnight = new WhiteKnight(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(blackKnight.isAllowedMove(new Point(x, y), null));
        sa.assertTrue(whiteKnight.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
    }

    @DataProvider
    public static Object[][] getCorrectMoves() {
        return new Object[][]{
                {5, 1},
                {3, 1},
                {6, 2},
                {2, 2},
                {6, 4},
                {2, 4},
                {5, 5},
                {3, 5}
        };
    }

    @Test(dataProvider = "getIncorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y) {
        Counter blackKnight = new BlackKnight(new Point(4, 3));
        Counter whiteKnight = new WhiteKnight(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(blackKnight.isAllowedMove(new Point(x, y), null));
        sa.assertFalse(whiteKnight.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
    }

    @DataProvider
    public static Object[][] getIncorrectMoves() {
        return new Object[][]{
                {4, 2},
                {5, 3},
                {4, 4},
                {3, 3},
                {6, 1},
                {6, 5},
                {2, 5},
                {2, 1}
        };
    }
}

