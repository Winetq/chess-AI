package counters;

import abstraction.Counter;
import counters.black.BlackBishop;
import counters.white.WhiteBishop;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

@Test
public class BishopTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter blackBishop = new BlackBishop(new Point(4, 3));
        Counter whiteBishop = new WhiteBishop(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(blackBishop.isAllowedMove(new Point(x, y), null));
        sa.assertTrue(whiteBishop.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
    }

    @DataProvider
    public static Object[][] getCorrectMoves() {
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

    @Test(dataProvider = "getIncorrectMoves")
    public void isAllowedMove_choosingIncorrectMoves_shouldBeFalse(int x, int y) {
        Counter blackBishop = new BlackBishop(new Point(4, 3));
        Counter whiteBishop = new WhiteBishop(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(blackBishop.isAllowedMove(new Point(x, y), null));
        sa.assertFalse(whiteBishop.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
    }

    @DataProvider
    public static Object[][] getIncorrectMoves() {
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

