class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        int size = isConnected.length;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getCount();
    }
    
    private class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;
        
        private UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count -= 1;
            }
        }
        
        private int getCount() {
            return count;
        }
    }
}

