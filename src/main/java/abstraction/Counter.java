package abstraction;

import javafx.util.Pair;
import sample.Game;

import java.awt.*;
import java.util.ArrayList;

public abstract class Counter {
    protected Point coordinates;
    protected String path;
    protected boolean isAlive;
    private int value;

    public Counter(Point coordinates, String path, int value) {
        this.coordinates = coordinates;
        this.path = path;
        this.isAlive = true;
        this.value = value;
    }

    public void move(Point newCoordinates) {
        this.coordinates = newCoordinates;
    }

    public void battle(Counter attackedCounter) {
        if (attackedCounter != null) attackedCounter.setAlive(false);
    }

    public abstract boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter);

    public abstract void generateAllPossibleMoves(Game game, ArrayList<Pair<Counter, Point>> allCurrentMoves);

    public int getX() {
        return coordinates.x;
    }

    public int getY() {
        return coordinates.y;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public String getPath() {
        return path;
    }

    public int getValue() {
        return value;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
