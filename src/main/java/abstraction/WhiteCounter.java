package abstraction;

import java.awt.Point;

public abstract class WhiteCounter extends Counter {
    public WhiteCounter(Point coordinates, String path, int value) {
        super(coordinates, path, value);
    }
}
