import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {


    private Node first;
    private int N;


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String i : args) {
            stack.push(i);

        }
        StdOut.print(stack.peek());
        StdOut.print(stack.peek());
        StdOut.print(stack.peek());
        StdOut.print(stack.pop());
        StdOut.print(stack.pop());
        StdOut.print(stack.peek());


    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (N > 0) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
        return null;
    }

    public Item peek() {
        if (first == null) return null;
        return first.item;
    }


    private class StackIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

}
