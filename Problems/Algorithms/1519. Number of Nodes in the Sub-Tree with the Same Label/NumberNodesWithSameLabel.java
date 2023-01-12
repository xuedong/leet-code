class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adj.computeIfAbsent(src, value -> new ArrayList<Integer>()).add(dest);
            adj.computeIfAbsent(dest, value -> new ArrayList<Integer>()).add(src);
        }

        int[] ans = new int[n];
        char[] labelArray = labels.toCharArray();
        dfs(0, -1, adj, labelArray, ans);
        return ans;
    }

    private int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj, char[] labels, int[] ans) {
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node] - 'a'] = 1;

        if (!adj.containsKey(node)) {
            return nodeCounts;
        }

        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }

            int[] childCounts = dfs(child, node, adj, labels, ans);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }
}
