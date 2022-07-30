class Solution {
    public int removeStones(int[][] stones) {
        int size = stones.length;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        
        int roots = 0;
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int root = uf.find(i);
            if (!used.contains(root)) {
                used.add(root);
                roots++;
            }
        }
        
        return size - roots;
    }
    
    private class UnionFind {
        private int[] root;
        private int[] rank;
        
        private UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
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
            }
        }
    }
}

