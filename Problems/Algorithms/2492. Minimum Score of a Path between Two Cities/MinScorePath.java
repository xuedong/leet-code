class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            int dist = road[2];
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, dist);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, dist);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Map.Entry<Integer, Integer> entry : graph.get(node).entrySet()) {
                int neighbor = entry.getKey();
                int dist = entry.getValue();
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }

                ans = Math.min(ans, dist);
            }
        }

        return ans;
    }
}
