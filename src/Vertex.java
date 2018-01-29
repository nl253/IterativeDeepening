import java.text.MessageFormat;

/**
 * @author Norbert Logiewa nl253
 */

public final class Vertex implements Comparable<Vertex> {

    @SuppressWarnings("WeakerAccess")
    public final int x, y;

    /**
     * @param x
     * @param y
     */

    public Vertex(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @SuppressWarnings({"ConditionalExpression", "SubtractionInCompareTo"})
    @Override
    public final int compareTo(
            @SuppressWarnings("ParameterNameDiffersFromOverriddenParameter")
            final Vertex v) {
        return (v.x == x) ? (v.y - y) : (v.x - x);
    }

    @SuppressWarnings({"OverlyComplexBooleanExpression", "ConstantOnLeftSideOfComparison", "OverlyComplexMethod"})
    public static boolean vertexIntersect(final Vertex u, final Vertex v1, final Vertex v2) {

        /* check whether the vertex u falls within a given line segment where
           the line segment connects vertices v1 and v2 (but does not include
           them) */

        int a = v1.x - v2.x;
        int b = u.x - v2.x;

        int c = v1.y - v2.y;
        int d = u.y - v2.y;

        /* check whether the simultaneous equations a mu = b and c mu = d
           has a solution 0 < mu < 1 where a and c are coefficients of the variable mu
           where b and d are constants */

        if (a < 0) {
            a = -a;
            b = -b;
        }

        if (c < 0) {
            c = -c;
            d = -d;
        }

        if ((a == 0) && (b == 0)) return (0 < d) && (d < c);
        else if ((c == 0) && (d == 0)) return (0 < b) && (b < a);
        else
            return (0 < b) && (b < a) && (0 < d) && (d < c) && ((a * d) == (b * c));

    }

    public static boolean linesIntersect(final Vertex u1, final Vertex u2, final Vertex v1, final Vertex v2) {

        /* check whether line segment 1 intersects line segment 2 where
           line segment 1 connects vertices u1 and u2 (but does not include
           them) and line segment 2 connects vertices v1 and v2 (but does not
           include them) */

        final int a = u1.x - u2.x;
        final int b = v2.x - v1.x;
        final int c = v2.x - u2.x;

        final int d = u1.y - u2.y;
        final int e = v2.y - v1.y;
        final int f = v2.y - u2.y;

        /* check whether the simultaneous equations a mu + b lambda = c and d mu + e
           lambda = f has a solution 0 < mu < 1 and 0 < lambda < 1 where a and d are
           coefficients of the variable mu where b and e are coefficients of the
           variable lambda where c and f are constants */

        //noinspection OverlyComplexBooleanExpression
        final Predicate intersectPredicate = (int denominator, int lambdaNumerator, int muNumerator) -> (lambdaNumerator > 0) && (lambdaNumerator < denominator) && (muNumerator > 0) && (muNumerator < denominator);
        return solve(a, b, c, d, e, f, intersectPredicate);
    }

    public static boolean vertexInterior(final Vertex u, final Vertex v1, final Vertex v2, final Vertex v3) {

        /* check whether u occurs inside the solid triangle defined the by three
           vertices v1, v2 and v3.
           The check returns false if u occurs in the perimeter of the triangle;
           it only returns true if u occurs in the interior of the triangle. */

        final int a = v1.x - v3.x;
        final int b = v2.x - v3.x;
        final int c = u.x - v3.x;

        final int d = v1.y - v3.y;
        final int e = v2.y - v3.y;
        final int f = u.y - v3.y;

        /* check whether the simultaneous equations a mu + b lambda = c and d mu + e
           lambda = f has a solution 0 < mu, 0 < lambda and mu + lambda < 1 where a
           and d are coefficients of the variable mu where b and e are coefficients
           of the variable lambda where c and f are constants */

        final Predicate interiorPredicate = (int denominator, int lambdaNumerator, int muNumerator) -> (muNumerator > 0) && (lambdaNumerator > 0) && ((muNumerator + lambdaNumerator) < denominator);
        return solve(a, b, c, d, e, f, interiorPredicate);
    }

    @SuppressWarnings("MethodWithTooManyParameters")
    private static boolean solve(final int a, final int b, final int c, final int d, final int e, final int f, final Predicate p) {
        int denominator = (d * b) - (a * e);

        if (denominator == 0) {
            return false;
        } else {
            int lambdaNumerator = (d * c) - (a * f);
            int muNumerator = (b * f) - (e * c);

            if (denominator < 0) {
                lambdaNumerator = -lambdaNumerator;
                muNumerator = -muNumerator;
                denominator = -denominator;
            }

            return p.predicate(denominator, lambdaNumerator, muNumerator);
        }
    }

    @Override
    public final String toString() {
        return MessageFormat.format("({0}, {1})", x, y);
    }

    @SuppressWarnings({"InterfaceMayBeAnnotatedFunctional", "PackageVisibleInnerClass"})
    interface Predicate {

        boolean predicate(int denominator, int lambdaNumerator, int muNumerator);
    }
}
