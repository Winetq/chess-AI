package counters;

import abstraction.Counter;
import counters.black.BlackKing;
import counters.white.WhiteKing;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

@Test
public class KingTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter blackKing = new BlackKing(new Point(4, 3));
        Counter whiteKing = new WhiteKing(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(blackKing.isAllowedMove(new Point(x, y), null));
        sa.assertTrue(whiteKing.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
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
        Counter blackKing = new BlackKing(new Point(4, 3));
        Counter whiteKing = new WhiteKing(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(blackKing.isAllowedMove(new Point(x, y), null));
        sa.assertFalse(whiteKing.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
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

