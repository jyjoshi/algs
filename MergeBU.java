/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class MergeBU {
    private static Comparable[] aux;
    private static int count = 0;

    public static void sort(Comparable[] a) {
        int N = a.length;
        count = 0;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }

    }

    public static void sortTrace(Comparable[] a) {
        int N = a.length;
        count = 0;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            // StdOut.println("\nSz : " + sz);
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                mergeTrace(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
        StdOut.println("Array Accesses : " + count);
    }

    public static void show(Comparable[] a) {
        for (Comparable i : a) {
            StdOut.print(i + " ");
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
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

    private static void mergeTrace(Comparable[] a, int lo, int mid, int hi) {
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
        }
    }

    public static void main(String[] args) {
        int N = 39;
        Comparable[] arr = new Comparable[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        StdRandom.shuffle(arr);
        // Comparable[] arr = { 'e', 'a', 's', 'y', 'q', 'u', 'e', 's', 't', 'i', 'o', 'n' };

        // StdOut.println("Before Sorting");
        // show(arr);
        sortTrace(arr);
        // StdOut.println("After Sorting");
        // show(arr);


        for (int n = 1; n <= 512; n++) {
            // Comparable[] arr = new Comparable[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            StdRandom.shuffle(arr);
            sortTrace(arr);
        }
    }
}
