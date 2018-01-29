import java.util.Arrays;
import java.util.Collection;
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
 * <p>
 * Each configuration is a {@link List} of {@link Vertex}.
 * Effectively, the class is meant to return a {@link List} of {@link List}s
 * of {@link Vertex}es.
 *
 * @author Norbert Logiewa nl253
 */

@SuppressWarnings("ClassHasNoToStringMethod")
public final class CombinationGenerator {

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Triangle> triangles;

    /**
     * @param triangles a {@link Collection} of {@link Triangle}s
     */

    @SuppressWarnings("WeakerAccess")
    public CombinationGenerator(final Collection<Triangle> triangles) {
        this.triangles = new HashSet<>(triangles);
    }

    /**
     * @param triangles an {@link java.lang.reflect.Array} of {@link Triangle}s
     */

    @SuppressWarnings({"OverloadedVarargsMethod", "WeakerAccess"})
    public CombinationGenerator(final Triangle... triangles) {
        this(Arrays.stream(triangles).collect(Collectors.toSet()));
    }

    /**
     * Produce a {@link List} of valid configurations.
     *
     * @param start first {@link Vertex}
     * @param dest second {@link Vertex}
     * @return a {@link List} of valid configurations ie {@link Vertex}s
     */

    @SuppressWarnings("PublicMethodNotExposedInInterface")
    public List<Vertex> generate(final Vertex start, final Vertex dest) {
        return iterativeDeepeningDepthFirstSearch(start, dest, triangles
                .size() * 3);
    }

    /**
     * Produce a {@link List} of valid configurations.
     *
     * @return solution ie a {@link List} of valid configurations
     */

    private List<Vertex> iterativeDeepeningDepthFirstSearch(final Vertex start, final Vertex dest, final int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            final List<Vertex> subResult = limitedDepthFirstSearch(start, dest, i);
            if ((subResult != null) && !subResult.isEmpty()) return subResult;
        }
        return null;
    }

    /**
     * @param start the start
     * @param dest the destination
     * @param depth max depth
     * @return a solution to the problem ie a {@link List} of {@link Vertex} representing a path from start to dest
     */

    private List<Vertex> limitedDepthFirstSearch(final Vertex start, final Vertex dest, final int depth) {

        // base case
        // start producing a route from the ground up
        if (start.equals(dest)) {
            final List<Vertex> vertices = new LinkedList<>();
            vertices.add(dest);
            return vertices;
        }

        // no solution
        else if (depth == 0) return null;

            // recursive case
        else {
            final List<Vertex> neighbours = getAdjecentVerticies(start);
            for (final Vertex neighbour : neighbours) {
                final List<Vertex> maybe = limitedDepthFirstSearch(dest, neighbour, depth - 1);
                if (maybe != null) {
                    maybe.add(start);
                    return maybe;
                }
            }
            return null;
        }
    }

    /**
     * @return a {@link List} of {@link Vertex}es adjecent to {@link Vertex} vertex
     */

    private List<Vertex> getAdjecentVerticies(final Vertex vertex) {
        return triangles.stream().flatMap((Triangle triangle) -> Stream
                .of(triangle.pointA, triangle.pointB, triangle.pointC))
                .filter((Vertex point) -> isValid(vertex, point))
                .collect(Collectors.toList());
    }

    /**
     * @param start first {@link Vertex}
     * @param dest second {@link Vertex}
     * @return true iff the configuration is valid ie if dest {@link Vertex} is not inside of a {@link Triangle} and if you don't cross any lines by traveling from start {@link Vertex} to dest {@link Vertex}
     */

    @SuppressWarnings("OverlyComplexBooleanExpression")
    private boolean isValid(final Vertex start, final Vertex dest) {
        return triangles.stream().noneMatch((Triangle x) -> Vertex
                .vertexInterior(dest, x.pointA, x.pointB, x.pointC) || Vertex
                .linesIntersect(x.pointA, x.pointB, start, dest) || Vertex
                .linesIntersect(x.pointA, x.pointC, start, dest));
    }

    /**
     * @param vertices a solution ({@link List} of {@link Vertex}es)
     * @return a {@link String} representation of the solution ({@link List} of {@link Vertex}es)
     */

    static String format(final Collection<Vertex> vertices) {
        return vertices.stream().map(Vertex::toString)
                .collect(Collectors.joining(" "));
    }
}

