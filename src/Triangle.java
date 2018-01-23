import java.text.MessageFormat;

/**
 * @author nl253
 */

public final class Triangle {

    @SuppressWarnings({"PackageVisibleField", "WeakerAccess", "PublicField"})
    public final Point pointA, pointB, pointC;

    public Triangle(final Point pointA, final Point pointB, final Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    @Override
    public final String toString() {
        return MessageFormat
                .format("Triangle<{0}, {1}, {2}>", pointA, pointB, pointC);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (!getClass().equals(obj.getClass()))) return false;

        final Triangle triangle = (Triangle) obj;

        return pointA.equals(triangle.pointA) && pointB
                .equals(triangle.pointB) && pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = (31 * result) + pointB.hashCode();
        result = (31 * result) + pointC.hashCode();
        return result;
    }
}
