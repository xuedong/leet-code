class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                ans = Math.max(ans, dfs(i, edges, dist, visited));
            }
        }

        return ans;
    }

    private int dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visited) {
        visited[node] = true;
        dist.put(node, dist.getOrDefault(node, 0));

        int neighbor = edges[node];
        if (neighbor == -1) {
            return -1;
        }
        if (visited[neighbor]) {
            if (dist.containsKey(neighbor)) {
                return dist.get(node) - dist.get(neighbor) + 1;
            } else {
                return -1;
            }
        }

        dist.put(neighbor, dist.get(node) + 1);
        return dfs(neighbor, edges, dist, visited);
    }
}
