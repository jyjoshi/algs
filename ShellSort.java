/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ShellSort {
    public static void main(String[] args) {
        int N = 100;
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        ShellSort.drawSort(a);
        ShellSort.show(a);
    }

    public static void drawShow(Comparable[] a, int index) {
        StdDraw.clear();
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < a.length; i++) {
            double x0 = i;
            double x1 = i;
            double y0 = 0;
            double y1 = Double.parseDouble(a[i].toString());
            if (i == index) {
                StdDraw.setPenRadius(0.02);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(x0, y0, x1, y1);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
            }
            StdDraw.line(x0, y0, x1, y1);

        }
    }

    public static void drawSort(Comparable[] a) {
        StdDraw.setXscale(0, a.length + 1);
        StdDraw.setYscale(-2, 100);
        int h = 1;
        Stack<Integer> integers = new Stack<>();
        // while (h < a.length / 3) h = (3 * h) + 1;
        while (h < a.length / 3) {
            integers.push(h);
            h = (3 * h) + 1;
        }
        while (!integers.isEmpty()) {
            h = integers.pop();
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
                ShellSort.drawShow(a, i);
            }
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(Comparable[] a) {
        int h = 1;
        Stack<Integer> integers = new Stack<>();
        // while (h < a.length / 3) h = (3 * h) + 1;
        while (h < a.length / 3) {
            integers.push(h);
            h = (3 * h) + 1;
        }
        while (!integers.isEmpty()) {
            h = integers.pop();
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }
    }

    public static void modifiedSort(Comparable[] a) {
        int h = 1;
        Stack<Integer> integers = new Stack<>();
        // while (h < a.length / 3) h = (3 * h) + 1;
        while (h < a.length / 3) {
            integers.push(h);
            h = (3 * h) + 1;
        }
        while (!integers.isEmpty()) {
            h = integers.pop();
            StdOut.println("Current h value : " + h);
            for (int i = h; i < a.length; i++) {
                int count = 0;
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    count++;
                }
                count++;
                double ratio = count / (double) a.length;

                StdOut.println("Ratio for h : " + h + " is " + ratio);

            }
        }
    }

}
