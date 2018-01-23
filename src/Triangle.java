import java.text.MessageFormat;
import java.util.Set;

/**
 * @author nl253
 */

public final class Triangle {

    @SuppressWarnings({"PackageVisibleField", "WeakerAccess", "PublicField"})
    public final Point pointA, pointB, pointC;

    /**
     * @param pointA point a
     * @param pointB point b
     * @param pointC point c
     */

    public Triangle(final Point pointA, final Point pointB, final Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    /**
     * @return an {@link java.lang.reflect.Array} of 3 {@link Segment}s
     */

    @SuppressWarnings("PublicMethodNotExposedInInterface")
    public Segment[] getSegments() {
        final Segment[] segments = new Segment[3];

        segments[0] = new Segment(pointA, pointB);
        segments[1] = new Segment(pointB, pointC);
        segments[2] = new Segment(pointA, pointC);

        return segments;
    }

    boolean isIn(final Point point) {
        final double a1 = new Triangle(pointA, pointB, point).area();
        final double a2 = new Triangle(pointC, pointB, point).area();
        final double a3 = new Triangle(pointA, pointC, point).area();
        return area() == (a1 + a2 + a3);
    }

    /**
     * @return area    = (Ax (By − Cy) + Bx (Cy − Ay) + Cx (Ay − By)) / 2
     */

    @SuppressWarnings("ImplicitNumericConversion")
    public double area() {
        return ((pointA.x * (pointB.y - pointC.y)) + (pointB.x * (pointC.y - pointA.y)) + (pointC.x * (pointA.y - pointB.y))) / 2;
    }

    /**
     * @param obj an {@link Object}
     * @return true iff obj is a {@link Triangle} and it's {@link Point}s are the same as {@link Point}s in this
     */

    @SuppressWarnings("FeatureEnvy")
    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof Triangle)) return false;

        final Triangle triangle = (Triangle) obj;

        return Set.of(pointA, pointB, pointC)
                .containsAll(Set.of(pointA, pointB, pointC));
    }

    @SuppressWarnings("FeatureEnvy")
    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = (31 * result) + pointB.hashCode();
        result = (31 * result) + pointC.hashCode();
        return result;
    }

    @Override
    public final String toString() {
        return MessageFormat
                .format("Triangle<{0}, {1}, {2}>", pointA, pointB, pointC);
    }
}
