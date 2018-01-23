import java.text.MessageFormat;

/**
 * @author nl253
 */

public final class Point {

    @SuppressWarnings("WeakerAccess")
    public final double x, y;

    /**
     * @param x
     * @param y
     */

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Point)) return false;
        final Point point = (Point) obj;
        return (point.x == x) && (point.y == y);
    }

    @Override
    public int hashCode() {
        double result = x;
        result = (31 * result) + y;
        return (int) result;
    }

    @Override
    public final String toString() {
        return MessageFormat.format("Point<x: {0}, y: {1}>", x, y);
    }
}
