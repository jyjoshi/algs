/* *****************************************************************************
 *  Name:              Jay Joshi
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Selection {
    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void drawShow(Comparable[] a) {
        StdDraw.clear();
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < a.length; i++) {
            double x0 = i;
            double x1 = i;
            double y0 = 0;
            double y1 = Double.parseDouble(a[i].toString());
            StdDraw.line(x0, y0, x1, y1);

        }
    }

    public static void drawSort(Comparable[] a) {
        StdDraw.setXscale(0, a.length + 1);
        StdDraw.setYscale(-2, 100);
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            Selection.drawShow(a);

        }
    }

    public static void main(String[] args) {
        Comparable[] arr = new Comparable[30];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        StdRandom.shuffle(arr);
        
        Selection.drawSort(arr);

    }
}
