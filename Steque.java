import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {

    private Node front;
    private Node rear;
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            front = node;
            rear = node;
        }
        else {
            node.next = front;
            front = node;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = front.item;
        front = front.next;
        size--;
        return item;

    }

    public void enqueue(Item item) {
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

    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item> {

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
        Steque<Integer> steque = new Steque<>();
        for (int i = 0; i < 5; i++) {
            steque.push(i);
            steque.enqueue(i);
        }

        for (int i : steque) {
            StdOut.println(i);
        }

    }

}
