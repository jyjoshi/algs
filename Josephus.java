/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;

public class Josephus {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        CircularLinkedList<Integer> integers = new CircularLinkedList<>();
        for (int i = 0; i < N; i++) {
            integers.enque(i);
        }

        Iterator iter = integers.iterator();

        for (int i = 0; i < N; i++) {
            int x = 0;
            for (int count = 0; count < M - 1; count++) {
                x = (int) iter.next();
            }
            iter.remove();
            StdOut.print(x + " ");
        }


    }
}
