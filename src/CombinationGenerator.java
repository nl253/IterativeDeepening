import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @SuppressWarnings("WeakerAccess")
    public final int maxX, maxY;

    @SuppressWarnings({"WeakerAccess", "PublicField"})
    public final Set<Triangle> triangles;

    public CombinationGenerator(final Collection<Triangle> triangles) {
        this.triangles = new HashSet<>(triangles);

        final Stream<Point> allPoints = this.triangles.stream()
                .flatMap(x -> Stream.of(x.pointA, x.pointB, x.pointC));

        maxX = allPoints.map(x -> x.x).max(Integer::compareTo).get();
        maxY = allPoints.map(x -> x.y).max(Integer::compareTo).get();
    }

    public List<Point> generate(final Point start, final Point dest) {

    }

    /**
     * X and Y in both points must be no smaller than 0.
     * X and Y in both points must be no greater than the greatest X and Y calculated in the constructor.
     *
     * @param start first {@link Point}
     * @param dest second {@link Point}
     * @return true iff the configuration is valid
     */

    @SuppressWarnings("OverlyComplexBooleanExpression")
    private boolean isValid(final Point start, final Point dest) {
        return (start.x >= 0) && (dest.x >= 0) && (start.x <= maxX) && (dest.x <= maxX) && (start.y >= 0) && (dest.y >= 0) && (start.y <= maxY) && (dest.y <= maxY);
    }
}

