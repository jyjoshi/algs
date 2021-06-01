import java.util.Arrays;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        // String x = args[args.length - 1];
        // int nums[] = new int[args.length - 1];
        // for (int i = 0; i < args.length - 1; i++) {
        //     nums[i] = Integer.parseInt(args[i]);
        // }
        int[] arr = { 8, 0, 8, 1, 8, 0, 9, 8, 0 };
        Arrays.sort(arr);
        int key = 8;
        int count = howMany(arr, key);
        StdOut.print(count);
        // int index = rank(arr, key);
        // if (index != -1) {
        //     int temp = index;
        //     while (temp != -1) {
        //         index = temp;
        //         temp = rank(arr, key, 0, index - 1, 0);
        //     }
        // // }
        // StdOut.println(index);
        // int lessCount = lessThan(arr, 8);
        // int index = rank(arr, 8);
        // int keys = keyCount(arr, 8, lessCount);
        // StdOut.print(lessCount);
        // StdOut.print(index);
        // StdOut.print(keys);

        // if (x.equals("+")) {
        //     for (int i = 0; i < nums.length; i++) {
        //         int result = rank(arr, nums[i]);
        //         if (result == -1) {
        //             StdOut.print("\n" + nums[i] + "\n");
        //         }
        //     }
        // }
        // else {
        //     for (int i = 0; i < nums.length; i++) {
        //         int result = rank(arr, nums[i]);
        //         if (result != -1) {
        //             StdOut.print("\n" + nums[i] + "\n");
        //         }
        //     }
        // }
    }

    public static int rank(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        return rank(arr, key, low, high, 1);
    }

    public static int rank(int arr[], int key, int low, int high, int depth) {
        // StdOut.printf("%s %s %s %s\n", "Check", low, high, depth);
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
                return rank(arr, key, low, high, depth + 1);
            }
            else if (arr[mid] < key) {
                low = mid + 1;
                return rank(arr, key, low, high, depth + 1);
            }
            else return mid;
        }
        return -1;
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

    public static int lessThan(int arr[], int key) {
        int result = rank(arr, key);
        if (result == -1)
            return -1;
        else {
            for (int i = result; i > 0; i--) {
                if (arr[i] != arr[i - 1])
                    return i;
            }
        }
        return -1;
    }

    public static int keyCount(int arr[], int key, int low) {
        int count = 0;
        for (int i = low; i < arr.length; i++) {
            if (arr[i] != key) {
                break;
            }
            count += 1;
        }
        return count;
    }

    public static int howMany(int[] a, int key) {
        int count = 0;
        int index = rank(a, key);
        if (index == -1) {
            return count;
        }
        else {
            count = 1;
            int down = index - 1;
            int up = index + 1;
            int upperIndex = index;
            int lowerIndex = index;
            while (down > -1 || up < a.length) {
                int indexDown = RecursiveBinarySearch.rank(a, key, 0, down, 0);
                int indexUp = RecursiveBinarySearch.rank(a, key, up, a.length - 1, 0);
                if (indexDown == -1) {
                    down = -1;
                }
                else {
                    count += lowerIndex - indexDown;
                    lowerIndex = indexDown;
                    down = indexDown - 1;
                }

                if (indexUp == -1) {
                    up = a.length;
                }
                else {
                    count += indexUp - upperIndex;
                    upperIndex = indexUp;
                    up = indexUp + 1;
                }
            }

        }
        return count;
    }
}
