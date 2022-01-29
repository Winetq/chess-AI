package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class BlackQueen extends BlackCounter {

    public BlackQueen(Point coordinates) {
        super(coordinates, "black\\queen.png", 90);
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (Math.abs(this.coordinates.x - potentialCoordinates.x) == Math.abs(this.coordinates.y - potentialCoordinates.y)) // left catty-corner or right catty-corner
            return true;
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

        // down left
        for (int i = coordinates.x + 1, j = coordinates.y + 1; i <= 7 && j <= 7; i++, j++) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // up left
        for (int i = coordinates.x - 1, j = coordinates.y - 1; i >= 0 && j >= 0; i--, j--) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // down right
        for (int i = coordinates.x - 1, j = coordinates.y + 1; i >= 0 && j <= 7; i--, j++) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }

        // up right
        for (int i = coordinates.x + 1, j = coordinates.y - 1; i <= 7 && j >= 0; i++, j--) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof WhiteCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof BlackCounter
                break;
        }
    }
    
    @Override
    public String toString() {
        return "BlackQueen(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
