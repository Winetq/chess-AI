package abstraction;

import counters.black.*;
import counters.white.*;
import javafx.util.Pair;
import sample.Game;

import java.awt.Point;
import java.util.ArrayList;

public class MoveGenerator {
    private Game game;

    public MoveGenerator(Game game) {
        this.game= game;
    }

    public void generateMovesForBlackCounters(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        if (counter instanceof BlackBishop)
            generateBlackBishopMoves(counter, allCurrentMoves);
        if (counter instanceof BlackKing)
            generateBlackKingMoves(counter, allCurrentMoves);
        if (counter instanceof BlackKnight)
            generateBlackKnightMoves(counter, allCurrentMoves);
        if (counter instanceof BlackPawn)
            generateBlackPawnMoves(counter, allCurrentMoves);
        if (counter instanceof BlackQueen)
            generateBlackQueenMoves(counter, allCurrentMoves);
        if (counter instanceof BlackRook)
            generateBlackRookMoves(counter, allCurrentMoves);
    }

    public void generateMovesForWhiteCounters(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        if (counter instanceof WhiteBishop)
            generateWhiteBishopMoves(counter, allCurrentMoves);
        if (counter instanceof WhiteKing)
            generateWhiteKingMoves(counter, allCurrentMoves);
        if (counter instanceof WhiteKnight)
            generateWhiteKnightMoves(counter, allCurrentMoves);
        if (counter instanceof WhitePawn)
            generateWhitePawnMoves(counter, allCurrentMoves);
        if (counter instanceof WhiteQueen)
            generateWhiteQueenMoves(counter, allCurrentMoves);
        if (counter instanceof WhiteRook)
            generateWhiteRookMoves(counter, allCurrentMoves);
    }

    private void generateBlackBishopMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // down left
        for (int i = counter.getX() + 1, j = counter.getY() + 1; i <= 7 && j <= 7; i++, j++){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // up left
        for (int i = counter.getX() - 1, j = counter.getY() - 1; i >= 0 && j >= 0; i--, j--){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // down right
        for (int i = counter.getX() - 1, j = counter.getY() + 1; i >= 0 && j <= 7; i--, j++){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // up right
        for (int i = counter.getX() + 1, j = counter.getY() - 1; i <= 7 && j >= 0; i++, j--){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }
    }

    private void generateWhiteBishopMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // down right
        for (int i = counter.getX() + 1, j = counter.getY() + 1; i <= 7 && j <= 7; i++, j++){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // up left
        for (int i = counter.getX() - 1, j = counter.getY() - 1; i >= 0 && j >= 0; i--, j--){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // down left
        for (int i = counter.getX() - 1, j = counter.getY() + 1; i >= 0 && j <= 7; i--, j++){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // up right
        for (int i = counter.getX() + 1, j = counter.getY() - 1; i <= 7 && j >= 0; i++, j--){
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }
    }

    private void generateBlackKingMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square up
        if (counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() - 1)));
        }

        // move one square left catty-corner up
        if (counter.getX() + 1 <= 7 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() - 1)));
        }

        // move one square left
        if (counter.getX() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY());
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY())));
        }

        // move one square left catty-corner down
        if (counter.getX() + 1 <= 7 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() + 1)));
        }

        // move one square down
        if (counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() + 1)));
        }

        // move one square right catty-corner down
        if (counter.getX() - 1 >= 0 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() + 1)));
        }

        // move one square right
        if (counter.getX() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY());
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY())));
        }

        // move one square right catty-corner up
        if (counter.getX() - 1 >= 0 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() - 1)));
        }
    }

    private void generateWhiteKingMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square up
        if (counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() - 1)));
        }

        // move one square right catty-corner up
        if (counter.getX() + 1 <= 7 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() - 1)));
        }

        // move one square right
        if (counter.getX() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY());
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY())));
        }

        // move one square right catty-corner down
        if (counter.getX() + 1 <= 7 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() + 1)));
        }

        // move one square down
        if (counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() + 1)));
        }

        // move one square left catty-corner down
        if (counter.getX() - 1 >= 0 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() + 1)));
        }

        // move one square left
        if (counter.getX() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY());
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY())));
        }

        // move one square left catty-corner up
        if (counter.getX() - 1 >= 0 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() - 1)));
        }
    }

    private void generateBlackKnightMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square left and two squares up
        if (counter.getX() + 1 <= 7 && counter.getY() - 2 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() - 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() - 2)));
        }

        // move two squares left and one square up
        if (counter.getX() + 2 <= 7 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 2, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 2, counter.getY() - 1)));
        }

        // move two squares left and one square down
        if (counter.getX() + 2 <= 7 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 2, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 2, counter.getY() + 1)));
        }

        // move one square left and two squares down
        if (counter.getX() + 1 <= 7 && counter.getY() + 2 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() + 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() + 2)));
        }

        // move one square right and two squares down
        if (counter.getX() - 1 >= 0 && counter.getY() + 2 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() + 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() + 2)));
        }

        // move two squares right and one square down
        if (counter.getX() - 2 >= 0 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 2, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 2, counter.getY() + 1)));
        }

        // move two squares right and one square up
        if (counter.getX() - 2 >= 0 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 2, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 2, counter.getY() - 1)));
        }

        // move one square right and two squares up
        if (counter.getX() - 1 >= 0 && counter.getY() - 2 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() - 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() - 2)));
        }
    }

    private void generateWhiteKnightMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square right and two squares up
        if (counter.getX() + 1 <= 7 && counter.getY() - 2 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() - 2);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() - 2)));
        }

        // move two squares right and one square up
        if (counter.getX() + 2 <= 7 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() + 2, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 2, counter.getY() - 1)));
        }

        // move two squares right and one square down
        if (counter.getX() + 2 <= 7 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 2, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 2, counter.getY() + 1)));
        }

        // move one square right and two squares down
        if (counter.getX() + 1 <= 7 && counter.getY() + 2 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() + 2);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() + 2)));
        }

        // move one square left and two squares down
        if (counter.getX() - 1 >= 0 && counter.getY() + 2 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() + 2);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() + 2)));
        }

        // move two squares left and one square down
        if (counter.getX() - 2 >= 0 && counter.getY() + 1 <= 7) {
            Counter attackedSquare = game.getCounter(counter.getX() - 2, counter.getY() + 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 2, counter.getY() + 1)));
        }

        // move two squares left and one square up
        if (counter.getX() - 2 >= 0 && counter.getY() - 1 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 2, counter.getY() - 1);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 2, counter.getY() - 1)));
        }

        // move one square left and two squares up
        if (counter.getX() - 1 >= 0 && counter.getY() - 2 >= 0) {
            Counter attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() - 2);
            if (attackedSquare == null || attackedSquare instanceof BlackCounter)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() - 2)));
        }
    }

    private void generateBlackPawnMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square up
        Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() + 1);
        if (attackedSquare == null)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() + 1)));

        // move two squares up
        attackedSquare = game.getCounter(counter.getX(), counter.getY() + 2);
        if (counter.isAllowedMove(new Point(counter.getX(), counter.getY() + 2), attackedSquare)
                && !game.isLeapedOverOthers(counter, new Point(counter.getX(), counter.getY() + 2)))
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() + 2)));

        // move one square left catty-corner
        attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() + 1);
        if (attackedSquare instanceof WhiteCounter)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() + 1)));

        // move one square right catty-corner
        attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() + 1);
        if (attackedSquare instanceof WhiteCounter)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() + 1)));
    }

    private void generateWhitePawnMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // move one square up
        Counter attackedSquare = game.getCounter(counter.getX(), counter.getY() - 1);
        if (attackedSquare == null)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() - 1)));

        // move two squares up
        attackedSquare = game.getCounter(counter.getX(), counter.getY() - 2);
        if (counter.isAllowedMove(new Point(counter.getX(), counter.getY() - 2), attackedSquare)
                && !game.isLeapedOverOthers(counter, new Point(counter.getX(), counter.getY() - 2)))
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), counter.getY() - 2)));

        // move one square right catty-corner
        attackedSquare = game.getCounter(counter.getX() + 1, counter.getY() - 1);
        if (attackedSquare instanceof BlackCounter)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() + 1, counter.getY() - 1)));

        // move one square left catty-corner
        attackedSquare = game.getCounter(counter.getX() - 1, counter.getY() - 1);
        if (attackedSquare instanceof BlackCounter)
            allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX() - 1, counter.getY() - 1)));
    }

    private void generateBlackQueenMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // just bishop and rook
        generateBlackRookMoves(counter, allCurrentMoves);
        generateBlackBishopMoves(counter, allCurrentMoves);
    }

    private void generateWhiteQueenMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // just bishop and rook
        generateWhiteRookMoves(counter, allCurrentMoves);
        generateWhiteBishopMoves(counter, allCurrentMoves);
    }

    private void generateBlackRookMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // up
        for (int i = counter.getY() - 1; i >= 0; i--){
            Counter attackedSquare = game.getCounter(counter.getX(), i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // down
        for (int i = counter.getY() + 1; i <= 7; i++){
            Counter attackedSquare = game.getCounter(counter.getX(), i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // left
        for (int i = counter.getX() - 1; i >= 0; i--){
            Counter attackedSquare = game.getCounter(i, counter.getY());
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // right
        for (int i = counter.getX() + 1; i <= 7; i++){
            Counter attackedSquare = game.getCounter(i, counter.getY());
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }
    }

    private void generateWhiteRookMoves(Counter counter, ArrayList<Pair<Counter, Point>> allCurrentMoves){
        // up
        for (int i = counter.getY() - 1; i >= 0; i--){
            Counter attackedSquare = game.getCounter(counter.getX(), i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // down
        for (int i = counter.getY() + 1; i <= 7; i++){
            Counter attackedSquare = game.getCounter(counter.getX(), i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(counter.getX(), i)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // left
        for (int i = counter.getX() - 1; i >= 0; i--){
            Counter attackedSquare = game.getCounter(i, counter.getY());
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // right
        for (int i = counter.getX() + 1; i <= 7; i++){
            Counter attackedSquare = game.getCounter(i, counter.getY());
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(counter, new Point(i, counter.getY())));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }
    }
}
