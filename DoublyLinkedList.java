/* *****************************************************************************
 *  Name:              Jay Joshi
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private int size;
    private DoubleNode first;
    private DoubleNode last;

    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {

        public boolean hasNext() {
            return false;
        }

        public Item next() {
            return null;
        }

        public void remove() {

        }
    }

    private class DoubleNode {
        private Item item;
        private DoubleNode next;
        private DoubleNode prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFront(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (first == null) {
            first = node;
            first.next = first;
            first.prev = first;
            last = first;
        }
        else {
            first.next = node;
            node.prev = first;
            first = first.next;
            first.next = null;
        }
        size++;
    }

    public void addRear(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (first == null) {
            first = node;
            first.next = first;
            first.prev = first;
            last = first;
        }
        else {
            node.next = last;
            last.prev = node;
            last = last.prev;
            last.prev = null;
        }
        size++;

    }

    public Item remFront() {
        if (isEmpty()) {
            return null;
        }
        Item item;
        if (size == 1) {
            item = first.item;
            first = null;
            last = null;
        }
        else {
            item = first.item;
            first = first.prev;
            first.next = null;
        }
        size--;
        return item;

    }

    public Item remRear() {
        if (isEmpty()) {
            return null;
        }
        Item item;
        if (size == 1) {
            item = first.item;
            first = null;
            last = null;
        }
        else {
            item = last.item;
            last = last.next;
            last.prev = null;
        }
        size--;
        return item;

    }

    public void insertBefore(Item item, Item newItem) {
        DoubleNode current = last;
        while (current != null) {
            if (current.item.equals(item)) {
                DoubleNode node = new DoubleNode();
                node.item = item;
                node.next = current;
                node.prev = current.prev;
                current.prev = node;
                size++;
                return;
            }
            current = current.next;
        }

    }

    public void insertAfter(Item item, Item newItem) {
        DoubleNode current = last;
        while (current != null) {
            if (current.item.equals(item)) {
                DoubleNode node = new DoubleNode();
                node.item = item;
                node.prev = current;
                node.next = current.next;
                current.next = node;
                size++;
                return;
            }
            current = current.next;
        }

    }

    public void remove() {
    }


    public static void main(String[] args) {

    }


}
