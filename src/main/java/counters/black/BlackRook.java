package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class BlackRook extends BlackCounter {

    public BlackRook(Point coordinates) {
        super(coordinates, "black\\rook.png");
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
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // down
        for (int i = coordinates.y + 1; i <= 7; i++) {
            Counter attackedSquare = game.getCounter(coordinates.x, i);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(coordinates.x, i)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // left
        for (int i = coordinates.x - 1; i >= 0; i--) {
            Counter attackedSquare = game.getCounter(i, coordinates.y);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // right
        for (int i = coordinates.x + 1; i <= 7; i++) {
            Counter attackedSquare = game.getCounter(i, coordinates.y);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, coordinates.y)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }
    }

    @Override
    public String toString() {
        return "BlackRook(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
