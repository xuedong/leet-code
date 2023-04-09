class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        int[][] count = new int[n][26];

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int ans = 1, visited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans = Math.max(ans, ++count[node][colors.charAt(node) - 'a']);
            visited++;

            if (!adj.containsKey(node)) {
                continue;
            }

            for (int neighbor : adj.get(node)) {
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return visited < n ? -1 : ans;
    }
}
