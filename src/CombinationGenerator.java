import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    public Map<Point, Point> edges;

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Triangle> triangles;

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Point> points;

    public CombinationGenerator(final Collection<Triangle> triangles) {
        this.triangles = new HashSet<>(triangles);

        points = this.triangles.stream().flatMap((Triangle triangle) -> Stream
                .of(triangle.pointA, triangle.pointB, triangle.pointC))
                .collect(Collectors.toSet());

        triangles.forEach((Triangle triangle) -> {
            edges.put(triangle.pointA, triangle.pointB);
            edges.put(triangle.pointB, triangle.pointC);
            edges.put(triangle.pointA, triangle.pointC);
        });
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
        return !edges.entrySet().stream().anyMatch((Map.Entry<Point, Point> edge) -> {
            edge.
        })
    }
}

