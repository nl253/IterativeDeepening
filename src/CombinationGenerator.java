import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link CombinationGenerator} takes a description of the problem ie a
 * {@link Collection} of {@link Triangle}s and produces a {@link java.util.List}
 * of valid configurations.
 *
 * @author nl253
 */

@SuppressWarnings("ClassHasNoToStringMethod")
public final class CombinationGenerator {

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public Set<Segment> segments;

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Triangle> triangles;

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Point> points;

    public CombinationGenerator(final Collection<Triangle> triangles) {
        this.triangles = new HashSet<>(triangles);

        points = this.triangles.stream().flatMap((Triangle triangle) -> Stream
                .of(triangle.pointA, triangle.pointB, triangle.pointC))
                .collect(Collectors.toSet());

        triangles.forEach((Triangle triangle) -> Collections
                .addAll(segments, triangle.getSegments()));
    }

    /**
     * Produce a {@link List} of valid configuartions.
     *
     * @param start first {@link Point}
     * @param dest second {@link Point}
     * @return a {@link List} of valid configurations ie {@link Point}s
     */

    public List<Point> generate(final Point start, final Point dest) {
        return new LinkedList<>();
    }

    /**
     * @param start first {@link Point}
     * @param dest second {@link Point}
     * @return true iff the configuration is valid
     */

    @SuppressWarnings("OverlyComplexBooleanExpression")
    private boolean isValid(final Point start, final Point dest) {
        return triangles.stream()
                .noneMatch((Triangle triangle) -> triangle.isIn(dest));
    }
}

