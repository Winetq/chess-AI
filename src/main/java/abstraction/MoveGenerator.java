package abstraction;

import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class MoveGenerator {
    private final Game game;

    public MoveGenerator(Game game) {
        this.game = game;
    }

    public void generateMovesForBlackCounters(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        if (counter instanceof BlackCounter) counter.generateAllPossibleMoves(game, allCurrentMoves);
    }

    public void generateMovesForWhiteCounters(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        if (counter instanceof WhiteCounter) counter.generateAllPossibleMoves(game, allCurrentMoves);
    }
}
