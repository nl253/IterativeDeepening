import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Norbert Logiewa nl253
 */

public final class FormatChecker {

    private FormatChecker() {}

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
        } catch (final IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static boolean parseOpeningBracket(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals("(")) {
                System.out.print("(");
                return parseX(st);
            } else return false;
        } else return true;
    }

    public static boolean parseX(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |,");
            int x = Integer.parseInt(token);
            if ((0 <= x) && (x < 24)) {
                System.out.print(String.valueOf(x));
                return parseComma(st);
            } else return false;
        } else {
            return false;
        }
    }

    public static boolean parseComma(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals(",")) {
                System.out.print(", ");
                return parseY(st);
            } else return false;
        } else return false;
    }

    public static boolean parseY(final StringTokenizer st) {

        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |)");
            int y = Integer.parseInt(token);
            if ((0 <= y) && (y < 24)) {
                System.out.print(String.valueOf(y));
                return parseClosingBracket(st);
            } else return false;
        } else return false;
    }

    public static boolean parseClosingBracket(final StringTokenizer st) {
        if (st.hasMoreTokens()) {
            final String token = st.nextToken(" |\n");
            if (token.equals(")")) {
                System.out.print(") ");
                return parseOpeningBracket(st);
            } else return false;
        } else return false;
    }
}
