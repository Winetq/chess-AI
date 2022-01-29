package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class BlackKing extends BlackCounter {

    public BlackKing(Point coordinates) {
        super(coordinates, "black\\king.png", 900);
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square up
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square left catty-corner up
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y == potentialCoordinates.y) // movement one square left
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square left catty-corner down
            return true;
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square right catty-corner down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y == potentialCoordinates.y) // movement one square right
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square right catty-corner up
            return true;

        return false; // other cases
    }
    
    @Override
    public void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        // move one square up
        if (coordinates.y - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x, coordinates.y - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, coordinates.y - 1)));
        }

        // move one square left catty-corner up
        if (coordinates.x + 1 <= 7 && coordinates.y - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y - 1)));
        }

        // move one square left
        if (coordinates.x + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y)));
        }

        // move one square left catty-corner down
        if (coordinates.x + 1 <= 7 && coordinates.y + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y + 1)));
        }

        // move one square down
        if (coordinates.y + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x, coordinates.y + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, coordinates.y + 1)));
        }

        // move one square right catty-corner down
        if (coordinates.x - 1 >= 0 && coordinates.y + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y + 1)));
        }

        // move one square right
        if (coordinates.x - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y)));
        }

        // move one square right catty-corner up
        if (coordinates.x - 1 >= 0 && coordinates.y - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y - 1)));
        }
    }
    
    @Override
    public String toString() {
        return "BlackKing(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
