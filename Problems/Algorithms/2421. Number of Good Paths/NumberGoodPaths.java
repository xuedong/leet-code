class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int parentX = find(x), parentY = find(y);

        if (parentX == parentY) {
            return;
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
}

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adj.computeIfAbsent(from, value -> new ArrayList<Integer>()).add(to);
            adj.computeIfAbsent(to, value -> new ArrayList<Integer>()).add(from);
        }

        int n = vals.length;
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tm.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind uf = new UnionFind(n);

        int ans = 0;
        for (int key : tm.keySet()) {
            for (int node : tm.get(key)) {
                if (!adj.containsKey(node)) {
                    continue;
                }

                for (int neighbor : adj.get(node)) {
                    if (vals[neighbor] <= vals[node]) {
                        uf.union(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int node : tm.get(key)) {
                int parent = uf.find(node);
                map.put(parent, map.getOrDefault(parent, 0) + 1);
            }

            for (int size : map.values()) {
                ans += size * (size + 1) / 2;
            }
        }

        return ans;
    }
}
