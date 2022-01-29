package counters.white;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class WhiteRook extends WhiteCounter {

    public WhiteRook(Point coordinates) {
        super(coordinates, "white\\rook.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x == potentialCoordinates.x || this.coordinates.y == potentialCoordinates.y) // vertically or horizontally
            return true;

        return false; // other cases
    }
    
    @Override
    public void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        // up
        for (int i = coordinates.y - 1; i >= 0; i--) {
            Counter attackedSquare = game.getCounter(coordinates.x, i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // down
        for (int i = coordinates.y + 1; i <= 7; i++) {
            Counter attackedSquare = game.getCounter(coordinates.x, i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // left
        for (int i = coordinates.x - 1; i >= 0; i--) {
            Counter attackedSquare = game.getCounter(i, coordinates.y);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // right
        for (int i = coordinates.x + 1; i <= 7; i++) {
            Counter attackedSquare = game.getCounter(i, coordinates.y);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }
    }

    @Override
    public String toString() {
        return "WhiteRook(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
