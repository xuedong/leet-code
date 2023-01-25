class Solution {
    public void dfs(int node, int[] edges, int[] dist, Boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, edges, dist, visited);
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        Boolean[] visited1 = new Boolean[n], visited2 = new Boolean[n];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        int ans = -1, min = Integer.MAX_VALUE;
        for (int curr = 0; curr < n; curr++) {
            if (min > Math.max(dist1[curr], dist2[curr])) {
                ans = curr;
                min = Math.max(dist1[curr], dist2[curr]);
            }
        }

        return ans;
    }
}
