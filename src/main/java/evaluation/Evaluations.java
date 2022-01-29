package evaluation;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import counters.black.*;
import counters.white.*;

public class Evaluations {
    private final int[][] positionsEvaluationForWhitePawn = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 50, 50, 50, 50, 50, 50, 50, 50},
            { 10, 10, 20, 30, 30, 20, 10, 10},
            { 5, 5, 10, 25, 25, 10, 5, 5},
            { 0, 0, 0, 20, 20, 0, 0, 0},
            { 5, -5,-10, 0, 0,-10, -5, 5},
            { 5, 10, 10,-20,-20, 10, 10, 5},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private final int[][] positionsEvaluationForBlackPawn = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 5, 10, 10,-20,-20, 10, 10, 5},
            { 5, -5,-10, 0, 0,-10, -5, 5},
            { 0, 0, 0, 20, 20, 0, 0, 0},
            { 5, 5, 10, 25, 25, 10, 5, 5},
            { 10, 10, 20, 30, 30, 20, 10, 10},
            { 50, 50, 50, 50, 50, 50, 50, 50},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private final int[][] positionsEvaluationForWhiteKnight = {
            { -50, -40, -30, -30, -30, -30, -40, -50},
            { -40, -20, 0, 0, 0, 0, -20, -40},
            { -30, 0, 10, 15, 15, 10, 0, -30},
            { -30, 5, 15, 20, 20, 15, 5, -30},
            { -30, 0, 15, 20, 20, 15, 0, -30},
            { -30, 5, 10, 15, 15, 10, 5, -30},
            { -40, -20, 0, 5, 5, 0, -20, -40},
            { -50, -40, -30, -30, -30, -30, -40, -50}
    };

    private final int[][] positionsEvaluationForBlackKnight = {
            { -50, -40, -30, -30, -30, -30, -40, -50},
            { -40, -20, 0, 5, 5, 0, -20, -40},
            { -30, 5, 10, 15, 15, 10, 5, -30},
            { -30, 0, 15, 20, 20, 15, 0, -30},
            { -30, 5, 15, 20, 20, 15, 5, -30},
            { -30, 0, 10, 15, 15, 10, 0, -30},
            { -40, -20, 0, 0, 0, 0,-20, -40},
            { -50, -40, -30, -30, -30, -30, -40, -50}
    };

    private final int[][] positionsEvaluationForWhiteBishop = {
            { -20, -10, -10, -10, -10, -10, -10, -20},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -10, 0, 5, 10, 10, 5, 0, -10},
            { -10, 5, 5, 10, 10, 5, 5, -10},
            { -10, 0, 10, 10, 10, 10, 0, -10},
            { -10, 10, 10, 10, 10, 10, 10, -10},
            { -10, 5, 0, 0, 0, 0, 5, -10},
            { -20, -10, -10, -10, -10, -10, -10, -20}
    };

    private final int[][] positionsEvaluationForBlackBishop = {
            { -20, -10, -10, -10, -10, -10, -10, -20},
            { -10, 5, 0, 0, 0, 0, 5, -10},
            { -10, 10, 10, 10, 10, 10, 10, -10},
            { -10, 0, 10, 10, 10, 10, 0, -10},
            { -10, 5, 5, 10, 10, 5, 5, -10},
            { -10, 0, 5, 10, 10, 5, 0, -10},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -20, -10, -10, -10, -10, -10, -10, -20}
    };

    private final int[][] positionsEvaluationForWhiteRook = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 5, 10, 10, 10, 10, 10, 10, 5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { 0, 0, 0, 5, 5, 0, 0, 0}
    };

    private final int[][] positionsEvaluationForBlackRook = {
            { 0, 0, 0, 5, 5, 0, 0, 0},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { 5, 10, 10, 10, 10, 10, 10, 5},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private final int[][] positionsEvaluationForWhiteQueen = {
            { -20, -10, -10, -5, -5, -10, -10, -20},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -10, 0, 5, 5, 5, 5, 0, -10},
            { -5, 0, 5, 5, 5, 5, 0, -5},
            { 0, 0, 5, 5, 5, 5, 0, -5},
            { -10, 5, 5, 5, 5, 5, 0, -10},
            { -10, 0, 5, 0, 0, 0, 0, -10},
            { -20, -10, -10, -5, -5, -10, -10, -20}
    };

    private final int[][] positionsEvaluationForBlackQueen = {
            { -20, -10, -10, -5, -5, -10, -10, -20},
            { -10, 0, 5, 0, 0, 0, 0, -10},
            { -10, 5, 5, 5, 5, 5, 0, -10},
            { 0, 0, 5, 5, 5, 5, 0, -5},
            { -5, 0, 5, 5, 5, 5, 0, -5},
            { -10, 0, 5, 5, 5, 5, 0, -10},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -20, -10, -10, -5, -5, -10, -10, -20}
    };

    private final int[][] positionsEvaluationForWhiteKing = {
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -20, -30, -30, -40, -40, -30, -30, -20},
            { -10, -20, -20, -20, -20, -20, -20, -10},
            { 20, 20, 0, 0, 0, 0, 20, 20},
            { 20, 30, 10, 0, 0, 10, 30, 20}
    };

    private final int[][] positionsEvaluationForBlackKing = {
            { 20, 30, 10, 0, 0, 10, 30, 20},
            { 20, 20, 0, 0, 0, 0, 20, 20},
            { -10, -20, -20, -20, -20, -20, -20, -10},
            { -20, -30, -30, -40, -40, -30, -30, -20},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30}
    };

    public int getValueEvaluationOfWhiteCounters(Counter counter) { // captures by black counters
        if (counter instanceof WhiteCounter) return counter.getValue();
        return 0;
    }

    public int getValueEvaluationOfBlackCounters(Counter counter) { // captures by white counters
        if (counter instanceof BlackCounter) return -counter.getValue();
        return 0;
    }

    public int getValueOfTheCounters(Counter counter) {
        return counter.getValue();
    }

    public int getPositionEvaluation(Counter counter, int x, int y) {
        if (counter instanceof BlackPawn) return positionsEvaluationForBlackPawn[y][x];
        if (counter instanceof BlackKnight) return positionsEvaluationForBlackKnight[y][x];
        if (counter instanceof BlackBishop) return positionsEvaluationForBlackBishop[y][x];
        if (counter instanceof BlackRook) return positionsEvaluationForBlackRook[y][x];
        if (counter instanceof BlackQueen) return positionsEvaluationForBlackQueen[y][x];
        if (counter instanceof BlackKing) return positionsEvaluationForBlackKing[y][x];
        if (counter instanceof WhitePawn) return positionsEvaluationForWhitePawn[y][x];
        if (counter instanceof WhiteKnight) return positionsEvaluationForWhiteKnight[y][x];
        if (counter instanceof WhiteBishop) return positionsEvaluationForWhiteBishop[y][x];
        if (counter instanceof WhiteRook) return positionsEvaluationForWhiteRook[y][x];
        if (counter instanceof WhiteQueen) return positionsEvaluationForWhiteQueen[y][x];
        if (counter instanceof WhiteKing) return positionsEvaluationForWhiteKing[y][x];
        return 0;
    }
}
