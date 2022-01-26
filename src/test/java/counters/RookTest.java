package counters;

import abstraction.Counter;
import counters.black.BlackRook;
import counters.white.WhiteRook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

@Test
public class RookTest {

    @Test(dataProvider = "getCorrectMoves")
    public void isAllowedMove_choosingCorrectMoves_shouldBeTrue(int x, int y) {
        Counter blackRook = new BlackRook(new Point(4, 3));
        Counter whiteRook = new WhiteRook(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(blackRook.isAllowedMove(new Point(x, y), null));
        sa.assertTrue(whiteRook.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
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
        Counter blackRook = new BlackRook(new Point(4, 3));
        Counter whiteRook = new WhiteRook(new Point(4, 3));
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(blackRook.isAllowedMove(new Point(x, y), null));
        sa.assertFalse(whiteRook.isAllowedMove(new Point(x, y), null));
        sa.assertAll();
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

