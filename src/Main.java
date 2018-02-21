import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Norbert Logiewa nl253
 */

@SuppressWarnings("MagicNumber")
public final class Main {

    /** Logger for the class */
    private static final Logger log = Logger.getAnonymousLogger();

    private Main() {}

    @SuppressWarnings({"ImplicitDefaultCharsetUsage", "OverlyLongMethod", "FeatureEnvy"})
    public static void main(final String... args) throws IOException {

        /* Copied from the PDF */
        final Triangle t0 = new Triangle(new Vertex(11, 0), new Vertex(13, 1), new Vertex(18, 5));
        final Triangle t1 = new Triangle(new Vertex(5, 4), new Vertex(7, 9), new Vertex(5, 8));
        final Triangle t2 = new Triangle(new Vertex(2, 3), new Vertex(4, 11), new Vertex(2, 6));
        final Triangle t3 = new Triangle(new Vertex(13, 7), new Vertex(14, 9), new Vertex(17, 10));
        final Triangle t4 = new Triangle(new Vertex(4, 9), new Vertex(11, 16), new Vertex(9, 11));
        final Triangle t5 = new Triangle(new Vertex(11, 3), new Vertex(19, 7), new Vertex(18, 10));
        final Triangle t6 = new Triangle(new Vertex(14, 10), new Vertex(17, 12), new Vertex(22, 11));
        final Triangle t7 = new Triangle(new Vertex(3, 1), new Vertex(12, 9), new Vertex(6, 9));
        final Triangle t8 = new Triangle(new Vertex(9, 11), new Vertex(13, 1), new Vertex(18, 5));
        final Triangle t9 = new Triangle(new Vertex(12, 2), new Vertex(18, 7), new Vertex(20, 8));
        final Triangle t10 = new Triangle(new Vertex(3, 3), new Vertex(10, 6), new Vertex(12, 8));
        final Triangle t11 = new Triangle(new Vertex(9, 15), new Vertex(16, 19), new Vertex(14, 15));
        final Triangle t12 = new Triangle(new Vertex(11, 2), new Vertex(18, 6), new Vertex(11, 3));
        final Triangle t13 = new Triangle(new Vertex(11, 11), new Vertex(2, 13), new Vertex(13, 17));
        final Triangle t14 = new Triangle(new Vertex(1, 13), new Vertex(2, 13), new Vertex(5, 20));
        final Triangle t15 = new Triangle(new Vertex(13, 16), new Vertex(17, 19), new Vertex(14, 20));

        // @formatter:off
        final SolutionGenerator solver = new SolutionGenerator(
                t0, t1, t2, t3, t4,
                t5, t6, t7, t8, t9,
                t10, t11, t12, t13, t15
        );
        // @formatter:on

        solver.solveProblem(new Vertex(13, 1), new Vertex(4, 9));
        solver.solveProblem(new Vertex(2, 13), new Vertex(19, 7));
        solver.solveProblem(new Vertex(9, 15), new Vertex(18, 5));
        solver.solveProblem(new Vertex(17, 19), new Vertex(11, 2));
        solver.solveProblem(new Vertex(1, 13), new Vertex(18, 5));
        solver.solveProblem(new Vertex(11, 11), new Vertex(18, 6));
        solver.solveProblem(new Vertex(11, 2), new Vertex(14, 20));
        solver.solveProblem(new Vertex(13, 7), new Vertex(14, 20));
        solver.solveProblem(new Vertex(10, 6), new Vertex(14, 20));
        solver.solveProblem(new Vertex(4, 11), new Vertex(18, 5));
        solver.solveProblem(new Vertex(5, 20), new Vertex(18, 5));
        solver.solveProblem(new Vertex(2, 6), new Vertex(18, 5));
    }
}
