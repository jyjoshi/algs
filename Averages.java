/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Averages {
    public static void main(String[] args) {
        StdOut.printf("%8s %7s %7s %7s", "Names", "Number1", "Number2", "Result\n");
        In in = new In();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] values = line.split(" ");
            formattedPrint(values);

        }

    }

    private static void formattedPrint(String[] values) {
        StdOut.printf("%7s ", values[0]);
        StdOut.printf("%7s ", values[1]);
        StdOut.printf("%7s ", values[2]);

        double value1 = Double.parseDouble(values[1]);
        double value2 = Double.parseDouble(values[2]);

        double result = value1 / value2;

        StdOut.printf("%7.3f\n", result);

    }
}




