import java.util.Iterator;

public class GeneralisedQueue<Item> implements Iterable<Item> {
    private Node rear;
    private Node front;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            front = node;
            rear = node;
        }

        else {
            rear.next = node;
            rear = rear.next;
        }
        size++;

    }

    public Item delete(int k) {
        if (k > size) {
            return null;
        }
        if (k == 1) {
            Item item = front.item;
            front = front.next;
            size--;
            return item;
        }
        if (k == size) {
            Node node = front;
            int i = 1;
            while (i < size - 1) {
                node = node.next;
                i++;
            }
            Item item = rear.item;
            rear = node;
            rear.next = null;
            size--;
            return item;
        }
        int i = 1;
        Node node = front;
        while (i < k - 1) {
            node = node.next;
        }
        Item item = node.next.item;
        node.next = node.next.next;
        size--;
        return item;


    }

    public Iterator<Item> iterator() {
        return new GeneralisedQueueIterator();
    }

    private class Node {
        private Item item;
        private Node next;
    }

    private class GeneralisedQueueIterator implements Iterator<Item> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        GeneralisedQueue<Integer> integers = new GeneralisedQueue<>();
        integers.insert(32);
        integers.insert(23);
        integers.insert(89);
        integers.insert(191);
        for (int i : integers) {
            StdOut.print(i);
            StdOut.print(" ");
        }
        StdOut.println();
        integers.delete(1);
        for (int i : integers) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        integers.delete(3);

        for (int i : integers) {
            StdOut.print(i + " ");
        }

    }
}
