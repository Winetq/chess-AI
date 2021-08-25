package sample;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.MoveGenerator;
import abstraction.WhiteCounter;
import counters.black.*;
import counters.white.*;
import evaluation.Evaluations;
import javafx.util.Pair;

import java.awt.Point;
import java.util.ArrayList;

public class Game {
    private boolean isEnd;
    private ArrayList<Counter> counters;
    private String winner;
    private MoveGenerator moveGenerator;
    private Evaluations evaluations;

    private boolean isLeapedOverOthersDiagonally(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getX() > counter.getX() && counters.get(i).getX() < newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) { // right diagonally down looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() < counter.getX() && counters.get(i).getX() > newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) { // left diagonally up looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() > counter.getX() && counters.get(i).getX() < newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) { // right diagonally up looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() < counter.getX() && counters.get(i).getX() > newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) { // left diagonally down looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
        }

        return false;
    }

    private boolean isLeapedOverOthersVertically(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getX() == counter.getX() && counters.get(i).getX() == newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) // up
                return true;
            if ((counters.get(i).getX() == counter.getX() && counters.get(i).getX() == newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) // down
                return true;
        }

        return false;
    }

    private boolean isLeapedOverOthersHorizontally(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getY() == counter.getY() && counters.get(i).getY() == newPoint.y) && (counters.get(i).getX() >
                    counter.getX() && counters.get(i).getX() < newPoint.x)) // right
                return true;
            if ((counters.get(i).getY() == counter.getY() && counters.get(i).getY() == newPoint.y) && (counters.get(i).getX() <
                    counter.getX() && counters.get(i).getX() > newPoint.x)) // left
                return true;
        }

        return false;
    }

    private void setEnd(boolean end) {
        isEnd = end;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Game() {
        this.isEnd = false;
        this.counters = new ArrayList<>();
        this.winner = null;
        this.moveGenerator = new MoveGenerator(this);
        this.evaluations = new Evaluations();
    }

    public void fillTheBoard(){
        // white counters
        for (int i = 0; i <= 7; i++){
            WhitePawn whitePawn = new WhitePawn(new Point(i, 6));
            counters.add(whitePawn);
        }

        WhiteRook whiteRook1 = new WhiteRook(new Point(0, 7));
        counters.add(whiteRook1);
        WhiteRook whiteRook2 = new WhiteRook(new Point(7, 7));
        counters.add(whiteRook2);

        WhiteKnight whiteKnight1 = new WhiteKnight(new Point(1, 7));
        counters.add(whiteKnight1);
        WhiteKnight whiteKnight2 = new WhiteKnight(new Point(6, 7));
        counters.add(whiteKnight2);

        WhiteBishop whiteBishop1 = new WhiteBishop(new Point(2, 7));
        counters.add(whiteBishop1);
        WhiteBishop whiteBishop2 = new WhiteBishop(new Point(5, 7));
        counters.add(whiteBishop2);

        WhiteQueen whiteQueen = new WhiteQueen(new Point(3, 7));
        counters.add(whiteQueen);

        WhiteKing whiteKing = new WhiteKing(new Point(4, 7));
        counters.add(whiteKing);

        // black counters
        for (int i = 0; i <= 7; i++){
            BlackPawn blackPawn = new BlackPawn(new Point(i, 1));
            counters.add(blackPawn);
        }

        BlackRook blackRook1 = new BlackRook(new Point(0, 0));
        counters.add(blackRook1);
        BlackRook blackRook2 = new BlackRook(new Point(7, 0));
        counters.add(blackRook2);

        BlackKnight blackKnight1 = new BlackKnight(new Point(1, 0));
        counters.add(blackKnight1);
        BlackKnight blackKnight2 = new BlackKnight(new Point(6, 0));
        counters.add(blackKnight2);

        BlackBishop blackBishop1 = new BlackBishop(new Point(2, 0));
        counters.add(blackBishop1);
        BlackBishop blackBishop2 = new BlackBishop(new Point(5, 0));
        counters.add(blackBishop2);

        BlackQueen blackQueen = new BlackQueen(new Point(3, 0));
        counters.add(blackQueen);

        BlackKing blackKing = new BlackKing(new Point(4, 0));
        counters.add(blackKing);
    }

    public Counter getCounter(int x, int y){
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i).getX() == x && counters.get(i).getY() == y)
                return counters.get(i);
        }
        return null;
    }

    public void deleteNotLivingCounter(){
        for (int i = 0; i < (int)counters.size(); i++){
            if (!counters.get(i).isAlive()) {
                counters.remove(i);
                i -= 1;
            }
        }
    }

    public boolean isLeapedOverOthers(Counter counter, Point newPoint){
        if (counter instanceof WhiteKnight || counter instanceof BlackKnight)
            return false;
        return isLeapedOverOthersDiagonally(counter, newPoint) || isLeapedOverOthersVertically(counter, newPoint) ||
                isLeapedOverOthersHorizontally(counter, newPoint);
    }

    public boolean isEndGame() {
        int kings = 0;
        boolean whiteKing = false;
        boolean blackKing = false;
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i) instanceof WhiteKing) {
                whiteKing = true;
                kings += 1;
            }
            if (counters.get(i) instanceof BlackKing) {
                blackKing = true;
                kings += 1;
            }
        }

        if (kings == 1) {
            this.setEnd(true);
            if (!whiteKing)
                setWinner("BLACK");
            else
                setWinner("WHITE");
        }

        return isEnd;
    }

    public void clearTheBoard(){
        counters.clear();
    }

    public void createCounter(String name, int x, int y){
        switch (name){
            // black counters
            case "BlackBishop":
                BlackBishop blackBishop = new BlackBishop(new Point(x, y));
                counters.add(blackBishop);
                break;
            case "BlackKing":
                BlackKing blackKing = new BlackKing(new Point(x, y));
                counters.add(blackKing);
                break;
            case "BlackKnight":
                BlackKnight blackKnight = new BlackKnight(new Point(x, y));
                counters.add(blackKnight);
                break;
            case "BlackPawn":
                BlackPawn blackPawn = new BlackPawn(new Point(x, y));
                counters.add(blackPawn);
                break;
            case "BlackQueen":
                BlackQueen blackQueen = new BlackQueen(new Point(x, y));
                counters.add(blackQueen);
                break;
            case "BlackRook":
                BlackRook blackRook = new BlackRook(new Point(x, y));
                counters.add(blackRook);
                break;
            // white counters
            case "WhiteBishop":
                WhiteBishop whiteBishop = new WhiteBishop(new Point(x, y));
                counters. add(whiteBishop);
                break;
            case "WhiteKing":
                WhiteKing whiteKing = new WhiteKing(new Point(x, y));
                counters.add(whiteKing);
                break;
            case "WhiteKnight":
                WhiteKnight whiteKnight = new WhiteKnight(new Point(x, y));
                counters.add(whiteKnight);
                break;
            case "WhitePawn":
                WhitePawn whitePawn = new WhitePawn(new Point(x, y));
                counters.add(whitePawn);
                break;
            case "WhiteQueen":
                WhiteQueen whiteQueen = new WhiteQueen(new Point(x, y));
                counters.add(whiteQueen);
                break;
            case "WhiteRook":
                WhiteRook whiteRook = new WhiteRook(new Point(x, y));
                counters.add(whiteRook);
                break;
        }
    }

    public void tradeUpToQueen(){
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i) instanceof WhitePawn){
                if (counters.get(i).getY() == 0){ // end of the board for white pawns
                    WhiteQueen whiteQueen = new WhiteQueen(new Point(counters.get(i).getX(), counters.get(i).getY()));
                    counters.add(whiteQueen);
                    counters.remove(i);
                    i -= 1;
                }
            }
            if (counters.get(i) instanceof BlackPawn){
                if (counters.get(i).getY() == 7){ // end of the board for black pawns
                    BlackQueen blackQueen = new BlackQueen(new Point(counters.get(i).getX(), counters.get(i).getY()));
                    counters.add(blackQueen);
                    counters.remove(i);
                    i -= 1;
                }
            }
        }
    }

    public void moveAI(){
        ArrayList<Pair<Counter, Point>> allPossibleMoves = new ArrayList<>();
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i) instanceof BlackCounter)
                moveGenerator.generateMovesForBlackCounters(counters.get(i), allPossibleMoves);
        }

        int index = chooseTheBestMoveAI(allPossibleMoves); // choosing the best move
        Counter chosenCounter = allPossibleMoves.get(index).getKey();
        Point newCoordinates = allPossibleMoves.get(index).getValue();
        Counter opponent = getCounter(newCoordinates.x, newCoordinates.y); // checking if it is a capture
        chosenCounter.move(newCoordinates);
        if (opponent != null)
            chosenCounter.battle(opponent);
    }

    private int chooseTheBestMoveAI(ArrayList<Pair<Counter, Point>> allCurrentMoves){
        int[] points = new int[allCurrentMoves.size()];
        for (int i = 0; i < allCurrentMoves.size(); i++){
            Counter currentCounter = allCurrentMoves.get(i).getKey();
            int newX = allCurrentMoves.get(i).getValue().x;
            int newY = allCurrentMoves.get(i).getValue().y;
            int X = allCurrentMoves.get(i).getKey().getX();
            int Y = allCurrentMoves.get(i).getKey().getY();

            int positionEvaluation = evaluations.getPositionEvaluation(currentCounter, newX, newY) - evaluations.getPositionEvaluation(currentCounter,
                    X, Y); // difference between new position and previous position

            int capture = 0;
            Counter attackedCounter = getCounter(newX, newY);
            if (attackedCounter != null)
                capture = evaluations.getValueEvaluationOfWhiteCounters(attackedCounter);

            points[i] = positionEvaluation + capture + minimax(allCurrentMoves.get(i), 5, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }

        int maximum = 0;
        for (int i = 1; i < points.length; i++){
            if (points[i] > points[maximum])
                maximum = i;
        }

        return maximum;
    }

    private int minimax(Pair<Counter, Point> move, int depth, int alpha, int beta, boolean isMaximizing){
        if (depth == 0)
            return evaluateBoard();

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            Counter analysedCounter = move.getKey();

            int previousX = analysedCounter.getX();
            int previousY = analysedCounter.getY();

            Point newCoordinates = move.getValue();
            Counter possibleOpponent = getCounter(newCoordinates.x, newCoordinates.y); // checking if it is a capture
            analysedCounter.move(newCoordinates);
            if (possibleOpponent != null)
                analysedCounter.battle(possibleOpponent);

            ArrayList<Pair<Counter, Point>> allPossibleMovesForBlackCounters = new ArrayList<>();
            for (int i = 0; i < (int)counters.size(); i++){
                if (counters.get(i) instanceof BlackCounter && counters.get(i).isAlive())
                    moveGenerator.generateMovesForBlackCounters(counters.get(i), allPossibleMovesForBlackCounters);
            }

            for (int i = 0; i < allPossibleMovesForBlackCounters.size(); i++){
                int score = minimax(allPossibleMovesForBlackCounters.get(i), depth - 1, alpha, beta, false);
                bestScore = Math.max(score, bestScore);
                alpha = Math.max(score, alpha);
                if (alpha >= beta)
                    break;
            }

            analysedCounter.move(new Point(previousX, previousY));
            if (possibleOpponent != null)
                possibleOpponent.setAlive(true);

            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;

            Counter analysedCounter = move.getKey();

            int previousX = analysedCounter.getX();
            int previousY = analysedCounter.getY();

            Point newCoordinates = move.getValue();
            Counter possibleOpponent = getCounter(newCoordinates.x, newCoordinates.y); // checking if it is a capture
            analysedCounter.move(newCoordinates);
            if (possibleOpponent != null)
                analysedCounter.battle(possibleOpponent);

            ArrayList<Pair<Counter, Point>> allPossibleMovesForWhiteCounters = new ArrayList<>();
            for (int i = 0; i < (int)counters.size(); i++){
                if (counters.get(i) instanceof WhiteCounter && counters.get(i).isAlive())
                    moveGenerator.generateMovesForWhiteCounters(counters.get(i), allPossibleMovesForWhiteCounters);
            }

            for (int i = 0; i < allPossibleMovesForWhiteCounters.size(); i++){
                int score = minimax(allPossibleMovesForWhiteCounters.get(i), depth - 1, alpha, beta, true);
                bestScore = Math.min(score, bestScore);
                beta = Math.min(score, beta);
                if (alpha >= beta)
                    break;
            }

            analysedCounter.move(new Point(previousX, previousY));
            if (possibleOpponent != null)
                possibleOpponent.setAlive(true);

            return bestScore;
        }
    }

    private int evaluateBoard(){
        int totalEvaluation = 0;
        for (int i = 0; i < counters.size(); i++){
            if (counters.get(i) instanceof BlackCounter && counters.get(i).isAlive())
                totalEvaluation += evaluations.getValueOfTheCounters(counters.get(i));
            if (counters.get(i) instanceof WhiteCounter && !counters.get(i).isAlive())
                totalEvaluation += evaluations.getValueEvaluationOfWhiteCounters(counters.get(i)); // capture
            if (counters.get(i) instanceof BlackCounter && !counters.get(i).isAlive())
                totalEvaluation += evaluations.getValueEvaluationOfBlackCounters(counters.get(i)); // capture by white counters
        }

        return totalEvaluation;
    }

    public String getWinner() {
        return winner;
    }
}
