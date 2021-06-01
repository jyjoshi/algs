/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;

public class demo {
    public static void main(String[] args) {
        CircularLinkedList<Integer> integers = new CircularLinkedList<>();
        CircularLinkedList.CircularLinkedListIterator iter = integers.iterator();
        iter.showRemove();

        for (int i = 0; i < 10; i++) {
            integers.enque(i);
        }
        Iterator x = integers.iterator();
        for (int i : integers) {
            StdOut.print(i);
        }
    }
}
