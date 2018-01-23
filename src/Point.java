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
}
