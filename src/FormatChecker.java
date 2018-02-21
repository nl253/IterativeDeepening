import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Norbert Logiewa nl253
 */

@SuppressWarnings({"AlibabaUndefineMagicConstant", "AliEqualsAvoidNull", "UseOfSystemOutOrSystemErr", "LiteralAsArgToStringEquals", "UseOfStringTokenizer", "ClassIndependentOfModule", "ClassUnconnectedToPackage", "HardcodedLineSeparator"})
final class FormatChecker {

    private FormatChecker() {}

    @SuppressWarnings({"ImplicitDefaultCharsetUsage", "StringConcatenation", "UseOfStringTokenizer", "StringBufferWithoutInitialCapacity"})
    public static void main(final String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            final StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            final StringTokenizer st = new StringTokenizer(sb.toString());
            if (parseOpeningBracket(st)) System.out.println("ok");
            else System.out.println("problem");
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    @SuppressWarnings("LiteralAsArgToStringEquals")
    private static boolean parseOpeningBracket(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            @SuppressWarnings("StringTokenizerDelimiter")
            final String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            //noinspection AliEqualsAvoidNull
            if (token.equals("(")) {
                System.out.print("(");
                return parseX(st);
            } else return false;
        } else return true;
    }

    @SuppressWarnings("MagicNumber")
    private static boolean parseX(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |,");
            final int x = Integer.parseInt(token);
            //noinspection ConstantOnLeftSideOfComparison
            if ((0 <= x) && (x < 24)) {
                System.out.print(String.valueOf(x));
                return parseComma(st);
            } else return false;
        } else {
            return false;
        }
    }

    @SuppressWarnings("UseOfStringTokenizer")
    private static boolean parseComma(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            @SuppressWarnings("StringTokenizerDelimiter")
            final String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            //noinspection LiteralAsArgToStringEquals
            if (token.equals(",")) {
                System.out.print(", ");
                return parseY(st);
            } else return false;
        } else return false;
    }

    @SuppressWarnings("ConstantOnLeftSideOfComparison")
    private static boolean parseY(@SuppressWarnings("UseOfStringTokenizer")
                                  final StringTokenizer st) {

        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |)");
            final int y = Integer.parseInt(token);
            if ((0 <= y) && (y < 24)) {
                System.out.print(String.valueOf(y));
                return parseClosingBracket(st);
            } else return false;
        } else return false;
    }

    private static boolean parseClosingBracket(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |\n");
            //noinspection AliEqualsAvoidNull
            if (token.equals(")")) {
                System.out.print(") ");
                return parseOpeningBracket(st);
            } else return false;
        } else return false;
    }
}
