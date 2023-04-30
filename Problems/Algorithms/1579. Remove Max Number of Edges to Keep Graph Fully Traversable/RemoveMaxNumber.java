class Solution {
    private class UnionFind {
        int[] parent;
        int[] rank;
        int components;

        public UnionFind(int n) {
            components = n;
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }
        
        int union(int x, int y) {       
            int parentX = find(x); 
            int parentY = find(y);

            if (parentX == parentY) {
                return 0;
            }

            if (rank[parentX] > rank[parentY]) {
                rank[parentX] += rank[parentY];
                parent[parentY] = parentX;
            } else {
                rank[parentY] += rank[parentX];
                parent[parentX] = parentY;
            }

            components--;
            return 1;
        }

        boolean isConnected() {
            return components == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (Alice.union(edge[1], edge[2]) | Bob.union(edge[1], edge[2]));
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += Alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                edgesRequired += Bob.union(edge[1], edge[2]);
            }
        }

        if (Alice.isConnected() && Bob.isConnected()) {
            return edges.length - edgesRequired;
        }
        
        return -1;
    }
}
