/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class UniqueArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8 };
        int[] result = unique(arr);
        for (int i = 0; i < result.length; i++) {
            StdOut.print(result[i]);
        }

    }

    public static int[] unique(int arr[]) {
        int a[] = new int[arr.length];
        a[0] = arr[0];
        int index = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
            }
            else {
                a[index] = arr[i + 1];
                index += 1;
            }
        }
        return a;
    }
}
