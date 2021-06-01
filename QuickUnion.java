/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickUnion {
    private int id[];
    private int count;

    public QuickUnion(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int q) {
        while (q != id[q]) {
            q = id[q];
        }
        return q;
    }

    public boolean connected(int p, int q) {
        find(p);
        find(q);
        return p == q;
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int pId = find(p);
        int qId = find(q);
        id[qId] = id[pId];
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnion uf = new QuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
    }
}
