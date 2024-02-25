class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int MAX = 100000;
        boolean[] has = new boolean[MAX+1];
        for (int x : nums) {
            has[x] = true;
        }

        int n = nums.length;
        if (n == 1) {
            return true;
        }

        if (has[1]) {
            return false;
        }

        int[] sieve = new int[MAX+1];
        for (int divisor = 2; divisor <= MAX; divisor++) {
            if (sieve[divisor] == 0) {
                for (int value = divisor; value <= MAX; value += divisor) {
                    sieve[value] = divisor;
                }
            }
        }

        UnionFind uf = new UnionFind(2 * MAX + 1);
        for (int x : nums) {
            int curr = x;
            while (curr > 1) {
                int factor = sieve[curr];
                int dummy = factor + MAX;
                if (uf.find(dummy) != uf.find(x)) {
                    uf.union(dummy, x);
                }

                while (curr % factor == 0) {
                    curr /= factor;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= MAX; i++) {
            if (has[i] && uf.find(i) == i) {
                count++;
            }
        }

        return count == 1;
    }
}

class UnionFind {
    public int[] uf;
    public int[] size;

    public UnionFind(int n) {
        uf = new int[n+1];
        size = new int[n+1];

        for (int i = 0; i <= n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        return uf[x] == x ? x : (uf[x] = find(uf[x]));
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx == fy) {
            return;
        }

        if (size[fx] > size[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }

        uf[fx] = fy;
        size[fy] += size[fx];
    }
}
