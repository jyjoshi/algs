/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class VisualCounter {
    private int N;
    private int max;
    private int count;
    private int val;

    public VisualCounter() {
        N = 100;
        max = 100;
        count = 0;
        val = 0;
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(0, N);

        StdDraw.setYscale(-max, max);
    }

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
        count = 0;
        val = 0;
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(0.015);
    }

    public void increment() {
        if (count >= N) {
            StdOut.print("Maximum operations conducted");
            return;
        }
        if (val == max) {
            StdOut.print("Maximum Value has been reached. \nOperation not possible");
            return;
        }
        this.count++;
        this.val++;
        StdDraw.point(count, val);

    }

    public void decrement() {
        if (count >= N) {
            StdOut.print("Maximum operations conducted. \nFurther use of counter not possible.");
            return;
        }
        if (Math.abs(val) >= max) {
            StdOut.print("Maximum value has been reached. \nOperations not possible.");
            return;
        }
        this.count++;
        this.val--;
        StdDraw.point(count, val);

    }

    public static void main(String args[]) {
        VisualCounter x = new VisualCounter(5, 10);
        x.increment();
        x.increment();
        x.decrement();
        x.increment();
        x.decrement();
        x.increment();
    }

}
