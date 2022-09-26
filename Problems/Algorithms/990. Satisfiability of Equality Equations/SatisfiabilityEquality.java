class Solution {
    int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            uf[rootX] = rootY;
        }
    }

    private int find(int x) {
        if (uf[x] == x) return x;
        return uf[x] = find(uf[x]);
    }
}
