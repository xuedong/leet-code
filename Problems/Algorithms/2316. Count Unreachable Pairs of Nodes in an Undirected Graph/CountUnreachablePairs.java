class Solution {
    public int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        int count = 1;
        if (!adj.containsKey(node)) {
            return count;
        }

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adj, visited);
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int [] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        long ans = 0;
        long curr =  0;
        long remain = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                curr = dfs(i, adj, visited);
                ans += curr * (remain - curr);
                remain -= curr;
            }
        }

        return ans;
    }
}
