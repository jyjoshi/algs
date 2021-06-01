/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Points {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point2D(Math.random(), Math.random());
        }
        draw(points);
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (points[i].distanceTo(points[j]) > max) {
                    max = points[i].distanceTo(points[j]);
                }
            }
        }
        StdOut.println();
        StdOut.print(max);

    }

    public static void draw(Point2D[] x) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < x.length; i++) {
            StdDraw.point(x[i].x(), x[i].y());
        }
    }
}
