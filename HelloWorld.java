/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class HelloWorld {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);

        System.out.println(ln(a));


    }

    public static String checkEqual(int x, int y, int z) {
        if (x == y && y == z) {
            return "Equal";
        }
        else return "Not Equal";
    }

    public static boolean inRange(double n) {
        if (n > 0 && n < 1) return true;
        else return false;
    }

    public static int lg(int n) {
        int pow = 1;
        int num = 2;
        while (num < n) {
            num *= 2;
            pow += 1;
        }
        return pow - 1;
    }

    public static int ln(int n) {
        int count = 0;
        if (n > 1) {
            return 1 + ln(n / (int) 2.71);
        }
        return 0;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
