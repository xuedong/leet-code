class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n-1) return -1;
        
        int[] visited = new int[n];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            int i = connection[0], j = connection[1];
            graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
            graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) ans++;
            dfs(i, n, graph, visited);
        }
        
        return ans - 1;
    }

    private void dfs(int i, int n, Map<Integer, List<Integer>> graph, int[] visited) {
        if (visited[i] == 1) return;
        visited[i] = 1;
        
        if (graph.containsKey(i)) {
            for (int j : graph.get(i)) {
                if (visited[j] == 0) {
                    dfs(j, n, graph, visited);
                }
            }
        }
    }
}
