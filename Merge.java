import java.awt.Color;

public class Merge {
    private static int count = 0;
    private static int compares = 0;


    public static void sort(Comparable[] a) {
        int N = a.length;
        count = 0;
        Comparable[] temp = new Comparable[N];
        sort(a, 0, N - 1, temp);
    }

    public static void sortTrace(Comparable[] a) {
        int N = a.length;
        count = 0;
        compares = 0;
        Comparable[] temp = new Comparable[a.length];
        sortTrace(a, 0, N - 1, temp);
        int bound = 6 * (int) Math.ceil((N * (Math.log(N))));
        StdOut.println("\nArray Accesses : " + count + "\n Bound : " + bound);

        StdDraw.setPenRadius(0.02);
        StdDraw.setXscale(-1, Math.log(N) + 1);
        StdDraw.setYscale(-1, bound * 1.2);
        StdDraw.setPenColor(Color.orange);
        StdDraw.point(Math.log(N), count);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.point(Math.log(N), bound);
        StdOut.println("Total number of compares is : " + compares);
    }

    private static void sortTrace(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sortTrace(a, lo, mid, aux);
        sortTrace(a, mid + 1, hi, aux);
        if (a[mid].compareTo(a[mid + 1]) <= 0) {
            compares++;
            return;
        }
        compares++;

        // for (int i = lo; i <= hi; i++) {
        //     aux[i] = a[i];
        // }

        mergeTrace(a, lo, mid, hi, aux);
    }

    private static void mergeTrace(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        // StdOut.println("merge(a, " + lo + ", " + mid + ", " + hi + ")");

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
            count += 2;
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                count += 2;
                a[k] = aux[j++];
            }
            else if (j > hi) {
                count += 2;
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                count += 2;
                a[k] = aux[j++];
            }
            else {
                count += 2;
                a[k] = aux[i++];
            }
            compares++;
        }
    }

    private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid + 1, hi, aux);
        merge(a, lo, mid, hi, aux);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    public static void show(Comparable[] a) {
        for (Comparable i : a) {
            StdOut.print(i + " ");
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        // int N = 39;
        // Comparable[] arr = new Comparable[N];
        // for (int i = 0; i < N; i++) {
        //     arr[i] = i;
        // }
        // StdRandom.shuffle(arr);
        // Comparable[] arr = { 'e', 'a', 's', 'y', 'q', 'u', 'e', 's', 't', 'i', 'o', 'n' };
        // StdOut.println("Before Sorting");
        // show(arr);
        // sortTrace(arr);
        // StdOut.println("\nAfter sorting: \n");
        // show(arr);

        for (int n = 1; n <= 100; n++) {
            Comparable[] arr = new Comparable[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            StdRandom.shuffle(arr);
            StdOut.print(n + " ");
            sortTrace(arr);
            show(arr);
        }

    }
}
