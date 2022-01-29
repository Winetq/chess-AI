package counters.white;

import abstraction.BlackCounter;
import abstraction.Counter;
import abstraction.WhiteCounter;
import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public class WhiteBishop extends WhiteCounter {

    public WhiteBishop(Point coordinates) {
        super(coordinates, "white\\bishop.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (Math.abs(this.coordinates.x - potentialCoordinates.x) == Math.abs(this.coordinates.y - potentialCoordinates.y)) // left catty-corner or right catty-corner
            return true;

        return false; // other cases
    }
    
    @Override
    public void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves) {
        // down right
        for (int i = coordinates.x + 1, j = coordinates.y + 1; i <= 7 && j <= 7; i++, j++) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // up left
        for (int i = coordinates.x - 1, j = coordinates.y - 1; i >= 0 && j >= 0; i--, j--) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // down left
        for (int i = coordinates.x - 1, j = coordinates.y + 1; i >= 0 && j <= 7; i--, j++) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }

        // up right
        for (int i = coordinates.x + 1, j = coordinates.y - 1; i <= 7 && j >= 0; i++, j--) {
            Counter attackedSquare = game.getCounter(i, j);
            if (attackedSquare == null)
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
            else if (attackedSquare instanceof BlackCounter) {
                allCurrentMoves.add(new Pair<>(this, new Point(i, j)));
                break;
            }
            else // attackedSquare instanceof WhiteCounter
                break;
        }
    }

    @Override
    public String toString() {
        return "WhiteBishop(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
