/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] arr = (Item[]) new Object[0];
    private int size = 0;
    private int count = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(Item item) {
        if (size <= count) {
            size = size * 2 + 1;
            Item[] tempArr = (Item[]) new Object[size];
            int i = 0;
            while (i < count) {
                tempArr[i] = arr[i];
                i++;
            }
            arr = tempArr;
            while (i < size) {
                arr[i] = null;
                i++;
            }
        }
        arr[count] = item;
        count++;

    }

    public static void main(String[] args) {
        RandomBag<Integer> integers = new RandomBag<>();
        for (int i = 0; i < 5; i++) {
            integers.add(i);
        }
        for (int i = 0; i < 6; i++) {
            StdOut.println("New loop");
            for (int j : integers) {
                StdOut.println(j);
            }
        }

    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private int index = 0;

        public BagIterator() {
            StdRandom.shuffle(arr);
        }

        public boolean hasNext() {
            return index <= count;
        }

        public Item next() {
            Item item = arr[index];
            index++;
            return item;
        }
    }
}
