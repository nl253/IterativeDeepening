import java.text.MessageFormat;

/**
 * @author nl253
 */

public final class Point {

    @SuppressWarnings("WeakerAccess")
    public final int x, y;

    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final String toString() {
        return MessageFormat.format("Point<{0}, {1}>", x, y);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (!getClass().equals(obj.getClass()))) return false;

        final Point point = (Point) obj;

        return (x == point.x) && (y == point.y);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = (31 * result) + y;
        return result;
    }
}
