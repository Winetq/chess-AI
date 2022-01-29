package counters.generator;

import abstraction.Counter;
import abstraction.MoveGenerator;
import javafx.util.Pair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Test
public class MoveGeneratorTest {
    private final Game game = new Game();
    private final MoveGenerator generator = new MoveGenerator(game);
    private ArrayList<Counter> counters;

    @BeforeClass
    public void createAllCounters() {
        game.createCounter("BlackBishop", 1, 2);
        game.createCounter("BlackKing", 4, 2);
        game.createCounter("BlackKnight", 6, 4);
        game.createCounter("BlackPawn", 3, 4);
        game.createCounter("BlackQueen", 2, 5);
        game.createCounter("BlackRook", 6, 5);
        game.createCounter("WhiteBishop", 6, 2);
        game.createCounter("WhiteKing", 4, 6);
        game.createCounter("WhiteKnight", 2, 3);
        game.createCounter("WhitePawn", 3, 1);
        game.createCounter("WhiteQueen", 1, 7);
        game.createCounter("WhiteRook", 0, 4);
    }

    @BeforeMethod
    public void getAllCounter() {
        counters = new ArrayList<>(List.of(
                game.getCounter(1, 2),
                game.getCounter(4, 2),
                game.getCounter(6, 4),
                game.getCounter(3, 4),
                game.getCounter(2, 5),
                game.getCounter(6, 5),
                game.getCounter(6, 2),
                game.getCounter(4, 6),
                game.getCounter(2, 3),
                game.getCounter(3, 1),
                game.getCounter(1, 7),
                game.getCounter(0, 4)
        ));
    }

    public void generateMovesForBlackCountersTest() {
        // given
        ArrayList<Pair<Counter, Point>> allPossibleMoves = new ArrayList<>();
        SoftAssert sa = new SoftAssert();
        // when
        for (Counter counter : counters) {
            generator.generateMovesForBlackCounters(counter, allPossibleMoves);
        }
        // then
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(0))).count(),
                5L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(1))).count(),
                8L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(2))).count(),
                6L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(3))).count(),
                1L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(4))).count(),
                15L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(5))).count(),
                6L
        );
        sa.assertEquals(
                allPossibleMoves.stream().collect(Collectors.groupingBy(Pair::getKey, Collectors.counting())).size(),
                6
        );
        sa.assertAll();
    }

    public void generateMovesForWhiteCountersTest() {
        // given
        ArrayList<Pair<Counter, Point>> allPossibleMoves = new ArrayList<>();
        SoftAssert sa = new SoftAssert();
        // when
        for (Counter counter : counters) {
            generator.generateMovesForWhiteCounters(counter, allPossibleMoves);
        }
        // then
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(6))).count(),
                8L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(7))).count(),
                8L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(8))).count(),
                6L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(9))).count(),
                1L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(10))).count(),
                17L
        );
        sa.assertEquals(
                allPossibleMoves.stream().filter(x -> x.getKey().equals(counters.get(11))).count(),
                10L
        );
        sa.assertEquals(
                allPossibleMoves.stream().collect(Collectors.groupingBy(Pair::getKey, Collectors.counting())).size(),
                6
        );
        sa.assertAll();
    }
}

