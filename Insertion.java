public class Insertion {
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
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                Insertion.drawShow(a);

            }
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        Comparable[] arr = new Comparable[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        StdRandom.shuffle(arr);
        Insertion.drawSort(arr);


    }
}
