import java.text.MessageFormat;

/**
 * @author Norbert Logiewa nl253
 */

public final class Segment {

    @SuppressWarnings({"PackageVisibleField", "PublicField", "WeakerAccess"})
    public final Vertex a, b;

    /**
     * @param a
     * @param b
     */

    @SuppressWarnings("WeakerAccess")
    public Segment(final Vertex a, final Vertex b) {
        this.a = a;
        this.b = b;
    }

    @SuppressWarnings({"OverlyComplexBooleanExpression", "FeatureEnvy"})
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Segment)) return false;
        final Segment segment = (Segment) obj;
        return (segment.a.equals(a) && segment.b.equals(b)) || (segment.a
                .equals(b) && segment.b.equals(a));
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = (31 * result) + b.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return MessageFormat
                .format("Segment<{0}, {1}>", a.toString(), b.toString());
    }
}
