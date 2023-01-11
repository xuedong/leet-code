class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adj.computeIfAbsent(src, value -> new ArrayList<Integer>()).add(dest);
            adj.computeIfAbsent(dest, value -> new ArrayList<Integer>()).add(src);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        if (!adj.containsKey(node)) {
            return 0;
        }

        int totalTime = 0, childTime = 0;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }

            childTime = dfs(child, node, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }
}
