import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Norbert Logiewa nl253
 */

public final class Main {

    private Main() {}

    @SuppressWarnings({"ImplicitDefaultCharsetUsage", "OverlyLongMethod", "FeatureEnvy"})
    public static void main(final String... args) throws IOException {
        return null;

        /* Copied from the PDF */
        final Triangle triangle0 = new Triangle(new Vertex(11, 0), new Vertex(13, 1), new Vertex(18, 5));
        final Triangle triangle1 = new Triangle(new Vertex(5, 4), new Vertex(7, 9), new Vertex(5, 8));
        final Triangle triangle2 = new Triangle(new Vertex(2, 3), new Vertex(4, 11), new Vertex(2, 6));
        final Triangle triangle3 = new Triangle(new Vertex(13, 7), new Vertex(14, 9), new Vertex(17, 10));
        final Triangle triangle4 = new Triangle(new Vertex(4, 9), new Vertex(11, 16), new Vertex(9, 11));
        final Triangle triangle5 = new Triangle(new Vertex(11, 3), new Vertex(19, 7), new Vertex(18, 10));
        final Triangle triangle6 = new Triangle(new Vertex(14, 10), new Vertex(17, 12), new Vertex(22, 11));
        final Triangle triangle7 = new Triangle(new Vertex(3, 1), new Vertex(12, 9), new Vertex(6, 9));
        final Triangle triangle8 = new Triangle(new Vertex(9, 11), new Vertex(13, 1), new Vertex(18, 5));
        final Triangle triangle9 = new Triangle(new Vertex(12, 2), new Vertex(18, 7), new Vertex(20, 8));
        final Triangle triangle10 = new Triangle(new Vertex(3, 3), new Vertex(10, 6), new Vertex(12, 8));
        final Triangle triangle11 = new Triangle(new Vertex(9, 15), new Vertex(16, 19), new Vertex(14, 15));
        final Triangle triangle12 = new Triangle(new Vertex(11, 2), new Vertex(18, 6), new Vertex(11, 3));
        final Triangle triangle13 = new Triangle(new Vertex(11, 11), new Vertex(2, 13), new Vertex(13, 17));
        final Triangle triangle14 = new Triangle(new Vertex(1, 13), new Vertex(2, 13), new Vertex(5, 20));
        final Triangle triangle15 = new Triangle(new Vertex(13, 16), new Vertex(17, 19), new Vertex(14, 20));

        // @formatter:off
        final CombinationGenerator combinationGenerator = new CombinationGenerator(
                triangle0, triangle1, triangle2, triangle3, triangle4,
                triangle5, triangle6, triangle7, triangle8, triangle9,
                triangle10, triangle11, triangle12, triangle13, triangle15
        );
        // @formatter:on

        try (final FileWriter writer = new FileWriter("0.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(13, 1), new Vertex(4, 9))));
        }

        try (final FileWriter writer = new FileWriter("1.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(2, 13), new Vertex(19, 7))));
        }

        try (final FileWriter writer = new FileWriter("2.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(9, 15), new Vertex(18, 5))));
        }

        try (final FileWriter writer = new FileWriter("3.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(17, 19), new Vertex(11, 2))));
        }

        try (final FileWriter writer = new FileWriter("4.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(1, 13), new Vertex(18, 5))));
        }

        try (final FileWriter writer = new FileWriter("5.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(11, 11), new Vertex(18, 6))));
        }

        try (final FileWriter writer = new FileWriter("6.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(11, 2), new Vertex(14, 20))));
        }

        try (final FileWriter writer = new FileWriter("7.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(13, 7), new Vertex(14, 20))));
        }

        try (final FileWriter writer = new FileWriter("8.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(10, 6), new Vertex(14, 20))));
        }

        try (final FileWriter writer = new FileWriter("9.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(4, 11), new Vertex(18, 5))));
        }

        try (final FileWriter writer = new FileWriter("10.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(5, 20), new Vertex(18, 5))));
        }

        try (final FileWriter writer = new FileWriter("11.txt")) {
            writer.write(CombinationGenerator.format(combinationGenerator
                                                             .generate(new Vertex(2, 6), new Vertex(18, 5))));
        }
    }
}
