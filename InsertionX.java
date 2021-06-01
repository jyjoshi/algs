/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class InsertionX {
    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void show(Comparable[] a) {
        for (Comparable x : a) {
            StdOut.println(x);
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable temp = a[i];
            int j = i - 1;
            for (; j >= 0 && less(temp, a[j]); j--) {
                a[j + 1] = a[j];
                if (j == 0) {
                    a[0] = temp;
                }
            }

            if (j != -1) {
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = { 5, 3, 2, 1 };
        InsertionX.show(arr);
        InsertionX.sort(arr);
        InsertionX.show(arr);

    }
}
