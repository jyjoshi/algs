/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class temp {
    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = { 3, 4, 5 };
        int[] res = sameElements(x, y);
        for (int i : res) {
            StdOut.println(i);
        }

    }

    public static int[] sameElements(int arr1[], int[] arr2) {
        int i1 = 0;
        int[] res = new int[arr1.length + arr2.length];
        int count = 0;
        int i2 = 0;
        while (!(i1 == arr1.length - 1 && i2 == arr2.length - 1)) {
            if (arr1[i1] == arr2[i2]) {
                res[count] = arr1[i1];
                count++;
                if (i1 < arr1.length)
                    i1++;
                if (i2 < arr2.length)
                    i2++;
            }
            else if (arr1[i1] > arr2[i2]) {
                if (i2 < arr2.length - 1) i2++;
                else break;
            }
            else {
                if (i1 < arr1.length - 1) i1++;
                else break;
            }
        }
        return res;
    }
}


