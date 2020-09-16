package evaluation;

import abstraction.Counter;
import counters.black.*;
import counters.white.*;

public class Evaluations {
    private int positionEvaluationForWhitePawn[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 50, 50, 50, 50, 50, 50, 50, 50},
            { 10, 10, 20, 30, 30, 20, 10, 10},
            { 5, 5, 10, 25, 25, 10, 5, 5},
            { 0, 0, 0, 20, 20, 0, 0, 0},
            { 5, -5,-10, 0, 0,-10, -5, 5},
            { 5, 10, 10,-20,-20, 10, 10, 5},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private int positionEvaluationForBlackPawn[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 5, 10, 10,-20,-20, 10, 10, 5},
            { 5, -5,-10, 0, 0,-10, -5, 5},
            { 0, 0, 0, 20, 20, 0, 0, 0},
            { 5, 5, 10, 25, 25, 10, 5, 5},
            { 10, 10, 20, 30, 30, 20, 10, 10},
            { 50, 50, 50, 50, 50, 50, 50, 50},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private int positionEvaluationForWhiteKnight[][] = {
            { -50, -40, -30, -30, -30, -30, -40, -50},
            { -40, -20, 0, 0, 0, 0, -20, -40},
            { -30, 0, 10, 15, 15, 10, 0, -30},
            { -30, 5, 15, 20, 20, 15, 5, -30},
            { -30, 0, 15, 20, 20, 15, 0, -30},
            { -30, 5, 10, 15, 15, 10, 5, -30},
            { -40, -20, 0, 5, 5, 0, -20, -40},
            { -50, -40, -30, -30, -30, -30, -40, -50}
    };

    private int positionEvaluationForBlackKnight[][] = {
            { -50, -40, -30, -30, -30, -30, -40, -50},
            { -40, -20, 0, 5, 5, 0, -20, -40},
            { -30, 5, 10, 15, 15, 10, 5, -30},
            { -30, 0, 15, 20, 20, 15, 0, -30},
            { -30, 5, 15, 20, 20, 15, 5, -30},
            { -30, 0, 10, 15, 15, 10, 0, -30},
            { -40, -20, 0, 0, 0, 0,-20, -40},
            { -50, -40, -30, -30, -30, -30, -40, -50}
    };

    private int positionEvaluationForWhiteBishop[][] = {
            { -20, -10, -10, -10, -10, -10, -10, -20},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -10, 0, 5, 10, 10, 5, 0, -10},
            { -10, 5, 5, 10, 10, 5, 5, -10},
            { -10, 0, 10, 10, 10, 10, 0, -10},
            { -10, 10, 10, 10, 10, 10, 10, -10},
            { -10, 5, 0, 0, 0, 0, 5, -10},
            { -20, -10, -10, -10, -10, -10, -10, -20}
    };

    private int positionEvaluationForBlackBishop[][] = {
            { -20, -10, -10, -10, -10, -10, -10, -20},
            { -10, 5, 0, 0, 0, 0, 5, -10},
            { -10, 10, 10, 10, 10, 10, 10, -10},
            { -10, 0, 10, 10, 10, 10, 0, -10},
            { -10, 5, 5, 10, 10, 5, 5, -10},
            { -10, 0, 5, 10, 10, 5, 0, -10},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -20, -10, -10, -10, -10, -10, -10, -20}
    };

    private int positionEvaluationForWhiteRook[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0},
            { 5, 10, 10, 10, 10, 10, 10, 5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { 0, 0, 0, 5, 5, 0, 0, 0}
    };

    private int positionEvaluationForBlackRook[][] = {
            { 0, 0, 0, 5, 5, 0, 0, 0},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { -5, 0, 0, 0, 0, 0, 0, -5},
            { 5, 10, 10, 10, 10, 10, 10, 5},
            { 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private int positionEvaluationForWhiteQueen[][] = {
            { -20, -10, -10, -5, -5, -10, -10, -20},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -10, 0, 5, 5, 5, 5, 0, -10},
            { -5, 0, 5, 5, 5, 5, 0, -5},
            { 0, 0, 5, 5, 5, 5, 0, -5},
            { -10, 5, 5, 5, 5, 5, 0, -10},
            { -10, 0, 5, 0, 0, 0, 0, -10},
            { -20, -10, -10, -5, -5, -10, -10, -20}
    };

    private int positionEvaluationForBlackQueen[][] = {
            { -20, -10, -10, -5, -5, -10, -10, -20},
            { -10, 0, 5, 0, 0, 0, 0, -10},
            { -10, 5, 5, 5, 5, 5, 0, -10},
            { 0, 0, 5, 5, 5, 5, 0, -5},
            { -5, 0, 5, 5, 5, 5, 0, -5},
            { -10, 0, 5, 5, 5, 5, 0, -10},
            { -10, 0, 0, 0, 0, 0, 0, -10},
            { -20, -10, -10, -5, -5, -10, -10, -20}
    };

    private int positionEvaluationForWhiteKing[][] = {
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -20, -30, -30, -40, -40, -30, -30, -20},
            { -10, -20, -20, -20, -20, -20, -20, -10},
            { 20, 20, 0, 0, 0, 0, 20, 20},
            { 20, 30, 10, 0, 0, 10, 30, 20}
    };

    private int positionEvaluationForBlackKing[][] = {
            { 20, 30, 10, 0, 0, 10, 30, 20},
            { 20, 20, 0, 0, 0, 0, 20, 20},
            { -10, -20, -20, -20, -20, -20, -20, -10},
            { -20, -30, -30, -40, -40, -30, -30, -20},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30},
            { -30, -40, -40, -50, -50, -40, -40, -30}
    };

    public Evaluations() {
    }

    public int getValueEvaluationOfWhiteCounters(Counter counter){ // captures by black counters
        if (counter instanceof WhitePawn)
            return 10;
        if (counter instanceof WhiteKnight)
            return 30;
        if (counter instanceof WhiteBishop)
            return 30;
        if (counter instanceof WhiteRook)
            return 50;
        if (counter instanceof WhiteQueen)
            return 90;
        if (counter instanceof WhiteKing)
            return 900;

        return 0;
    }

    public int getValueEvaluationOfBlackCounters(Counter counter){ // captures by white counters
        if (counter instanceof BlackPawn)
            return -10;
        if (counter instanceof BlackKnight)
            return -30;
        if (counter instanceof BlackBishop)
            return -30;
        if (counter instanceof BlackRook)
            return -50;
        if (counter instanceof BlackQueen)
            return -90;
        if (counter instanceof BlackKing)
            return -900;

        return 0;
    }

    public int getValueOfTheCounters(Counter counter){
        if (counter instanceof WhitePawn || counter instanceof BlackPawn)
            return 10;
        if (counter instanceof WhiteKnight || counter instanceof BlackKnight)
            return 30;
        if (counter instanceof WhiteBishop || counter instanceof BlackBishop)
            return 30;
        if (counter instanceof WhiteRook || counter instanceof BlackRook)
            return 50;
        if (counter instanceof WhiteQueen || counter instanceof BlackQueen)
            return 90;
        if (counter instanceof WhiteKing || counter instanceof BlackKing)
            return 900;

        return 0;
    }

    public int getPositionEvaluation(Counter counter, int x, int y){
        if (counter instanceof BlackPawn)
            return getPositionEvaluationForBlackPawn(x, y);
        if (counter instanceof BlackKnight)
            return getPositionEvaluationForBlackKnight(x, y);
        if (counter instanceof BlackBishop)
            return getPositionEvaluationForBlackBishop(x, y);
        if (counter instanceof BlackRook)
            return getPositionEvaluationForBlackRook(x, y);
        if (counter instanceof BlackQueen)
            return getPositionEvaluationForBlackQueen(x, y);
        if (counter instanceof BlackKing)
            return getPositionEvaluationForBlackKing(x, y);

        if (counter instanceof WhitePawn)
            return getPositionEvaluationForWhitePawn(x, y);
        if (counter instanceof WhiteKnight)
            return getPositionEvaluationForWhiteKnight(x, y);
        if (counter instanceof WhiteBishop)
            return getPositionEvaluationForWhiteBishop(x, y);
        if (counter instanceof WhiteRook)
            return getPositionEvaluationForWhiteRook(x, y);
        if (counter instanceof WhiteQueen)
            return getPositionEvaluationForWhiteQueen(x, y);
        if (counter instanceof WhiteKing)
            return getPositionEvaluationForWhiteKing(x, y);

        return 0;
    }

    private int getPositionEvaluationForWhitePawn(int x, int y) {
        return positionEvaluationForWhitePawn[y][x];
    }

    private int getPositionEvaluationForBlackPawn(int x, int y) {
        return positionEvaluationForBlackPawn[y][x];
    }

    private int getPositionEvaluationForWhiteKnight(int x, int y) {
        return positionEvaluationForWhiteKnight[y][x];
    }

    private int getPositionEvaluationForBlackKnight(int x, int y) {
        return positionEvaluationForBlackKnight[y][x];
    }

    private int getPositionEvaluationForWhiteBishop(int x, int y) {
        return positionEvaluationForWhiteBishop[y][x];
    }

    private int getPositionEvaluationForBlackBishop(int x, int y) {
        return positionEvaluationForBlackBishop[y][x];
    }

    private int getPositionEvaluationForWhiteRook(int x, int y) {
        return positionEvaluationForWhiteRook[y][x];
    }

    private int getPositionEvaluationForBlackRook(int x, int y) {
        return positionEvaluationForBlackRook[y][x];
    }

    private int getPositionEvaluationForWhiteQueen(int x, int y) {
        return positionEvaluationForWhiteQueen[y][x];
    }

    private int getPositionEvaluationForBlackQueen(int x, int y) {
        return positionEvaluationForBlackQueen[y][x];
    }

    private int getPositionEvaluationForWhiteKing(int x, int y) {
        return positionEvaluationForWhiteKing[y][x];
    }

    private int getPositionEvaluationForBlackKing(int x, int y) {
        return positionEvaluationForBlackKing[y][x];
    }
}
