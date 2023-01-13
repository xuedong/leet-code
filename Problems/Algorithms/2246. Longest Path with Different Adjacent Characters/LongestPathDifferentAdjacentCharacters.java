class Solution {
    int longest = 1;

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            adj.computeIfAbsent(parent[i], value -> new ArrayList<Integer>()).add(i);
        }

        dfs(0, adj, s);
        return longest;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adj, String s) {
        if (!adj.containsKey(node)) {
            return 1;
        }

        int chain1 = 0, chain2 = 0;
        for (int child : adj.get(node)) {
            int longestChain = dfs(child, adj, s);

            if (s.charAt(node) == s.charAt(child)) continue;

            if (longestChain > chain1) {
                chain2 = chain1;
                chain1 = longestChain;
            } else if (longestChain > chain2) {
                chain2 = longestChain;
            }

            longest = Math.max(longest, 1 + chain1 + chain2);
        }

        return chain1 + 1;
    }
}
