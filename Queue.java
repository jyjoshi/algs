public class Queue<Item> {
    private Node front;
    private Node rear;
    private int N;


    private class Node {
        private Item item;
        private Node next;
    }

    public void enque(Item item) {
        Node oldRear = rear;
        rear = new Node();
        rear.item = item;
        rear.next = null;
        if (isEmpty()) front = rear;
        else oldRear.next = rear;
        N++;
    }

    public Item deque() {
        Item item = front.item;
        front = front.next;
        if (isEmpty()) rear = null;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return front == null;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enque(1);
        StdOut.print(queue.deque());

    }
}
