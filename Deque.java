/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;
import java.util.StringJoiner;

public class Deque<Item> implements Iterable<Item> {
    private DoubleNode left;
    private DoubleNode right;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void pushLeft(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        }

        else {
            left.prev = node;
            node.next = left;
            left = left.prev;
        }
        size++;

    }

    public void pushRight(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        }
        else {
            right.next = node;
            node.prev = right;
            right = right.next;
        }
        size++;

    }

    public Item popLeft() {
        Item item = left.item;
        left = left.next;
        left.prev = null;
        size--;
        return item;

    }

    public Item popRight() {
        Item item = right.item;
        right = right.prev;
        right.next = null;
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private DoubleNode current = left;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class DoubleNode {
        private Item item;
        private DoubleNode next;
        private DoubleNode prev;
    }

    public static void main(String[] args) {
        StdOut.println("\nTest Pop Right");

        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popRight();
        deque.popRight();

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: a");
    }
}
