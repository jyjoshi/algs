import java.util.Iterator;

public class CircularLinkedList<Item> implements Iterable<Item> {

    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enque(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            last = node;
            last.next = last;
        }
        else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        size++;
    }

    public Item deque() {
        if (isEmpty()) {
            return null;
        }
        Item item;
        if (size == 1) {
            item = last.item;
            last = null;
        }
        else {
            item = last.next.item;
            last.next = last.next.next;
        }
        return item;


    }

    public CircularLinkedListIterator iterator() {
        return new CircularLinkedListIterator();
    }

    public class CircularLinkedListIterator implements Iterator<Item> {
        private Node current;
        private int count;

        public CircularLinkedListIterator() {
            if (last != null && size > 1) {
                current = last.next;
            }
            else {
                current = last;
            }
        }


        public boolean hasNext() {
            return count < size;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            count++;
            return item;
        }

        public void remove() {
            Node iterator = last.next;
            for (; !iterator.next.equals(current); iterator = iterator.next) ;
            iterator.next = current.next;
            current = current.next;
            size--;

        }

        public Item showRemove() {
            Node iterator = last.next;
            for (; !iterator.next.equals(current); iterator = iterator.next) ;
            iterator.next = current.next;
            Item item = current.item;
            current = current.next;
            size--;
            return item;
        }
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> integers = new CircularLinkedList<>();
        CircularLinkedList<Integer>.CircularLinkedListIterator iter = integers.iterator();


        for (int i = 0; i < 10; i++) {
            integers.enque(i);
        }
        Iterator<Integer> x = integers.iterator();
        for (int i : integers) {
            StdOut.print(i);
        }

    }
}
