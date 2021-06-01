/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class StackAgain<Item> {
    public static void main(String[] args) {
        StackAgain<String> stack = new StackAgain<>();
        for (int i = 0; i < args.length; i++) {
            String item = args[i];
            if (item.equals("-")) {
                System.out.println(stack.pop());
            }
            else {
                stack.push(item);
            }

        }
    }

    private class Node {
        Item item;
        Node next;
    }

    Node first = new Node();
    int N;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

}
