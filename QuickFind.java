/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) id[i] = id[q];
        }
        count--;
    }

    public static void main(String[] args) {

    }
}
