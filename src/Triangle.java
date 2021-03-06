import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;

/**
 * {@link Triangle} is how I chose encode the problem.
 * For the purpose of checking if {@link Triangle} edges are crossed,
 * {@link Vertex} objects need to be grouped into 3s.
 * A {@link Collection} of {@link Triangle} is fed into {@link SolutionGenerator}
 * which then runs the algorithm to produces a solution.
 *
 * @author Norbert Logiewa nl253
 */

final class Triangle {

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Vertex pointA, pointB, pointC;

    /**
     * @param pointA point a
     * @param pointB point b
     * @param pointC point c
     */

    @SuppressWarnings("WeakerAccess")
    Triangle(final Vertex pointA, final Vertex pointB, final Vertex pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    /**
     * @param o an {@link Object}
     * @return true iff o is a {@link Triangle} and it's {@link Vertex}s are the same as {@link Vertex}s in this
     */

    @Override
    public boolean equals(final Object o) {

        if (!(o instanceof Triangle)) return false;

        final Triangle triangle = (Triangle) o;

        final Collection<Vertex> a = new HashSet<>(3);
        a.add(pointA);
        a.add(pointB);
        a.add(pointC);

        final Collection<Vertex> b = new HashSet<>(3);
        b.add(triangle.pointA);
        b.add(triangle.pointB);
        b.add(triangle.pointC);

        return a.containsAll(b);
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
