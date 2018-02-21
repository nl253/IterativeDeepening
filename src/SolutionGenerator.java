import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link SolutionGenerator} takes a description of the problem ie a
 * {@link Collection} of {@link Triangle}s and produces a {@link java.util.List}
 * of valid configurations.
 * <p>
 * Each configuration is a {@link List} of {@link Vertex}.
 *
 * {@link SolutionGenerator} internally keeps track of how many problems have been solved
 * and assigns a (problem) number to each problem.
 *
 * @author Norbert Logiewa nl253
 */

@SuppressWarnings({"ClassHasNoToStringMethod", "AssignmentToStaticFieldFromInstanceMethod"})
final class SolutionGenerator {

    private static final int NUMBER_OF_TRIANGLES = 16;

    @SuppressWarnings("RedundantFieldInitialization")
    private static int PROBLEM_COUNTER = 0;

    /** Logger for the class */
    private static final Logger log = Logger.getAnonymousLogger();

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Triangle> triangles;

    /**
     * @param triangles a {@link Collection} of {@link Triangle}s
     */

    @SuppressWarnings({"WeakerAccess", "AssertStatement"})
    SolutionGenerator(final Collection<Triangle> triangles) {
        assert triangles
                .size() == NUMBER_OF_TRIANGLES : "You need 16 triangles to solve the problem";
        this.triangles = new HashSet<>(triangles);
    }

    /**
     * @param triangles an {@link java.lang.reflect.Array} of {@link Triangle}s
     */

    @SuppressWarnings({"OverloadedVarargsMethod", "WeakerAccess"})
    SolutionGenerator(final Triangle... triangles) {
        this(Arrays.stream(triangles).collect(Collectors.toSet()));
    }

    void solveProblem(final Vertex start, final Vertex dest) throws IOException {
        log.info(MessageFormat
                         .format("Solving problem {0}, writing solution to file {0}.txt", PROBLEM_COUNTER));
        writeSolutionToFile(PROBLEM_COUNTER, formatSolution(findPath(start, dest)));
        PROBLEM_COUNTER++; // get ready for next problem
    }

    /**
     * Produce a valid configuration.
     *
     * @param start first {@link Vertex}
     * @param dest second {@link Vertex}
     * @return a {@link List} of valid configurations ie {@link Vertex}s
     */

    @SuppressWarnings("TypeMayBeWeakened")
    private List<Vertex> findPath(final Vertex start, final Vertex dest) {
        return iterativeDeepeningDepthFirstSearch(start, dest, triangles
                .size() * 3);
    }

    /**
     * Produce a valid configuration.
     *
     * @return a valid configuration.
     */

    private List<Vertex> iterativeDeepeningDepthFirstSearch(final Vertex start, final Vertex dest, final int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            final List<Vertex> subResult = limitedDepthFirstSearch(start, dest, i);
            if ((subResult != null) && !subResult.isEmpty()) return subResult;
        }
        return null;
    }

    /**
     * @param start the starting {@link Vertex}
     * @param dest the destination {@link Vertex}
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
            final Set<Vertex> neighbours = getAdjacentVertices(start);
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
     * @return a {@link Set} of {@link Vertex}es adjacent to {@link Vertex} vertex
     */

    private Set<Vertex> getAdjacentVertices(final Vertex vertex) {
        return triangles.stream().flatMap((Triangle triangle) -> Stream
                .of(triangle.pointA, triangle.pointB, triangle.pointC))
                .filter((Vertex point) -> isValid(vertex, point))
                .collect(Collectors.toSet());
    }

    /**
     * @param start first {@link Vertex}
     * @param dest second {@link Vertex}
     * @return true iff the configuration is valid ie if dest {@link Vertex} is not inside of a {@link Triangle} and if you don't cross any lines by traveling from start {@link Vertex} to dest {@link Vertex}
     */

    @SuppressWarnings("FeatureEnvy")
    private boolean isValid(final Vertex start, final Vertex dest) {
        return triangles.stream().noneMatch((Triangle x) -> Vertex
                .vertexInterior(dest, x.pointA, x.pointB, x.pointC) || Vertex
                .linesIntersect(x.pointA, x.pointB, start, dest) || Vertex
                .linesIntersect(x.pointA, x.pointC, start, dest) || Vertex
                .linesIntersect(x.pointB, x.pointC, start, dest));
    }

    /**
     * Write the solution to it's corresponding file.
     *
     * @param problemNo the id (number) to identify problem
     * @param formattedSolution textual solution to the problem
     */

    @SuppressWarnings("ImplicitDefaultCharsetUsage")
    private static void writeSolutionToFile(final int problemNo, final String formattedSolution) throws IOException {
        try (final FileWriter writer = new FileWriter(problemNo + ".txt")) {
            writer.write(formattedSolution);
        }
    }


    /**
     * @param vertices a solution ({@link List} of {@link Vertex}es)
     * @return a {@link String} representation of the solution ({@link List} of {@link Vertex}es)
     */

    private static String formatSolution(final Collection<Vertex> vertices) {
        return vertices.stream().map(Vertex::toString)
                .collect(Collectors.joining(" "));
    }
}

