/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Exercise2_2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        In in = new In();
        Interval1D[] intervals = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            String temp = in.readLine();
            String[] x = temp.split(" ");
            double start = Double.parseDouble(x[0]);
            double end = Double.parseDouble(x[1]);

            intervals[i] = new Interval1D(start, end);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.print(intervals[i]);
                    StdOut.print(intervals[j]);
                    StdOut.println();
                }
            }
        }
    }
}
