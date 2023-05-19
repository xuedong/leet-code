class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) {
                continue;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int neighbor : graph[curr]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[curr];
                        queue.add(neighbor);
                    } else if (color[neighbor] != -color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
