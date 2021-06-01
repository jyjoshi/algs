/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CircularRotation {
    public static void main(String[] args) {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";
        StdOut.println();
        StdOut.print(isCircularRotation(s1, s2));


    }

    public static String shiftLeft(String x) {
        String a = x.substring(0, 1);
        String b = x.substring(1, x.length());
        return b + a;
    }

    public static boolean isCircularRotation(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        }
        else {
            for (int i = 0; i < x.length(); i++) {
                if (x.equals(y)) {
                    return true;
                }
                x = shiftLeft(x);
            }
            return false;
        }
    }
}
