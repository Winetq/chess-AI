package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class BlackKnight extends BlackCounter {

    public BlackKnight(Point coordinates) {
        super(coordinates, "black\\knight.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square left and two squares up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares left and one square up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares left and one square down
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square left and two squares down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square right and two squares down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares right and one square down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares right and one square up
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square right and two squares up
            return true;

        return false; // other cases
    }
    
    @Override
    public void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        // move one square left and two squares up
        if (coordinates.x + 1 <= 7 && coordinates.y - 2 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y - 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y - 2)));
        }

        // move two squares left and one square up
        if (coordinates.x + 2 <= 7 && coordinates.y - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x + 2, coordinates.y - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 2, coordinates.y - 1)));
        }

        // move two squares left and one square down
        if (coordinates.x + 2 <= 7 && coordinates.y + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x + 2, coordinates.y + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 2, coordinates.y + 1)));
        }

        // move one square left and two squares down
        if (coordinates.x + 1 <= 7 && coordinates.y + 2 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y + 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y + 2)));
        }

        // move one square right and two squares down
        if (coordinates.x - 1 >= 0 && coordinates.y + 2 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y + 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y + 2)));
        }

        // move two squares right and one square down
        if (coordinates.x - 2 >= 0 && coordinates.y + 1 <= 7) {
            Counter attackedSquare = game.getCounter(coordinates.x - 2, coordinates.y + 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 2, coordinates.y + 1)));
        }

        // move two squares right and one square up
        if (coordinates.x - 2 >= 0 && coordinates.y - 1 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x - 2, coordinates.y - 1);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 2, coordinates.y - 1)));
        }

        // move one square right and two squares up
        if (coordinates.x - 1 >= 0 && coordinates.y - 2 >= 0) {
            Counter attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y - 2);
            if (attackedSquare == null || attackedSquare instanceof WhiteCounter)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y - 2)));
        }
    }

    @Override
    public String toString() {
        return "BlackKnight(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
