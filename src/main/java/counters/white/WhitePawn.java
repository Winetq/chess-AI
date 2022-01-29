package counters.white;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class WhitePawn extends WhiteCounter {

    public WhitePawn(Point coordinates) {
        super(coordinates, "white\\pawn.png", 10);
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        // white pawns
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter == null) // movement one square up
            return true;
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y
                && this.coordinates.y == 6 && attackedCounter == null) // movement two squares up
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square left catty-corner
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square right catty-corner
            return true;

        return false; // other cases
    }
    
    @Override
    public void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        // move one square up
        Counter attackedSquare = game.getCounter(coordinates.x, coordinates.y - 1);
        if (attackedSquare == null)
            allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, coordinates.y - 1)));

        // move two squares up
        attackedSquare = game.getCounter(coordinates.x, coordinates.y - 2);
        if (isAllowedMove(new Point(coordinates.x, coordinates.y - 2), attackedSquare)
                && !game.isLeapedOverOthers(this, new Point(coordinates.x, coordinates.y - 2)))
            allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, coordinates.y - 2)));

        // move one square right catty-corner
        attackedSquare = game.getCounter(coordinates.x + 1, coordinates.y - 1);
        if (attackedSquare instanceof BlackCounter)
            allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x + 1, coordinates.y - 1)));

        // move one square left catty-corner
        attackedSquare = game.getCounter(coordinates.x - 1, coordinates.y - 1);
        if (attackedSquare instanceof BlackCounter)
            allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x - 1, coordinates.y - 1)));
    }

    @Override
    public String toString() {
        return "WhitePawn(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
