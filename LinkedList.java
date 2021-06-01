import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private Node first;
    private int N;


    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        // LinkedList<String> strings = new LinkedList<>();

        integers.insert(1);
        integers.insert(100);
        integers.insert(10);
        integers.insert(1000);
        integers.insert(10000);
        integers.insert(102);
        integers.insert(1);
        integers.insert(1);
        // strings.insert("Hi");
        // strings.insert("my");
        // strings.insert("name");
        // strings.insert("is");
        // strings.insert("Jay");
        // strings.insert("Hi");
        // strings.insert("Nice");
        // strings.insert("Nice");
        // strings.insert("Nice");
        // strings.insert("Fry");
        // strings.insert("Sly");
        // strings.insert("Nice");
        // for (String i : strings) {
        //     System.out.println(i);
        // }

        for (int i : integers) {
            StdOut.println(i);
        }

        LinkedList<Integer>.Node firstNode = integers.getFirst();

        StdOut.print(integers.max(firstNode));
        // LinkedList<String>.Node node = strings.createNode("is");
        // System.out.println("Node created");
        // strings.removeAfter(node);
        //
        // StdOut.println("Result after removing an element");
        // for (String i : strings) {
        //     StdOut.println(i);
        // }
        //
        // StdOut.println("Result after adding an element.");
        //
        // LinkedList<String>.Node addNode = strings.createNode("Jay");
        //
        // strings.insertAfter(node, addNode);
        //
        // for (String i : strings) {
        //     StdOut.println(i);
        // }
        // strings.remove("Nice");
        // for (String i : strings) {
        //     StdOut.print(i);
        // }


    }

    public Node getFirst() {
        return first;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        private Item item;
        private Node next;
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            Node iterator = first;
            while (!iterator.next.equals(current)) {
                iterator = iterator.next;
            }
            iterator.next = current.next;
            current = current.next;

        }


    }


    public int size() {
        return N;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        }
        else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node();
            newNode.item = item;
            current.next = newNode;
        }
        N++;
    }


    public void removeAfter(Node node) {
        if (node != null) {
            Node current = first;
            while (current.next != null) {

                if (current.item.equals(node.item)) {
                    current.next = current.next.next;
                    N--;
                    return;
                }
                current = current.next;
            }
        }
    }


    public Node createNode(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        return newNode;
    }

    public void insertAfter(Node node, Node newNode) {
        if (node != null && newNode != null) {
            Node current = first;
            while (current != null) {
                if (current.item.equals(node.item)) {
                    Node temp = current.next;
                    current.next = newNode;
                    newNode.next = temp;
                    N++;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void remove(Item item) {
        Node sentinel = new Node();
        sentinel.next = first;
        while (sentinel.next != null) {
            if (sentinel.next.item.equals(item)) {
                sentinel.next = sentinel.next.next;
                continue;
            }
            sentinel = sentinel.next;
        }
    }

    public int max(Node node) {
        if (node == null) return 0;
        int max = 0;
        while (node != null) {
            if (max < (Integer) node.item) {
                max = (Integer) node.item;
            }
            node = node.next;
        }
        return max;
    }


}
