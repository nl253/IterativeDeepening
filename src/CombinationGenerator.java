import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    public final Set<Triangle> triangles;

    public CombinationGenerator(final Collection<Triangle> triangles) {
        this.triangles = new HashSet<>(triangles);
    }

    /**
     * Produce a {@link List} of valid configurations.
     *
     * @param start first {@link Point}
     * @param dest second {@link Point}
     * @return a {@link List} of valid configurations ie {@link Point}s
     */

    public List<List<Point>> generate(final Point start, final Point dest) {
        final List<List<Point>> result = new LinkedList<>();

        // iterative deepening cap
        final int edgeCount = triangles.size() * 3;

        return result;
    }

    private List<Point> limitedDepthFirstSearch(final Point start, final Point dest, final int depth) {

        // start producing a route from the ground up
        if (start.equals(dest)) return List.of(dest);

            // no solution
        else if (depth == 0) return null;

        else {

        }
    }


    /**
     * @param start first {@link Point}
     * @param dest second {@link Point}
     * @return true iff the configuration is valid
     */

    @SuppressWarnings("OverlyComplexBooleanExpression")
    private boolean isValid(final Point start, final Point dest) {
        return triangles.stream().noneMatch((Triangle triangle) -> triangle
                .isIn(dest) || triangle.isIn(start));
    }
}

