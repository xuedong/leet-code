class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int[] edge = dislikes[i];
            int s = edge[0];
            int t = edge[1];

            if (!graph.containsKey(s)) {
                graph.put(s, new LinkedList<Integer>());
            }
            graph.get(s).add(t);
            graph.put(s, graph.get(s));

            if (!graph.containsKey(t)) {
                graph.put(t, new LinkedList<Integer>());
            }
            graph.get(t).add(s);
            graph.put(t, graph.get(t));
        }
        
        int[] color = new int[n];
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i-1]) {
                color[i-1] = 1;
                queue.offer(i);
                
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    
                    if (visited[curr-1]) continue;
                    visited[curr-1] = true;
                    
                    if (!graph.containsKey(curr)) continue;
                    for (int neighbor : graph.get(curr)) {
                        if (color[neighbor-1] == color[curr-1]) return false;
                        
                        if (color[curr-1] == 1) {
                            color[neighbor-1] = 2;
                        } else {
                            color[neighbor-1] = 1;
                        }
                        
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return true;
    }
}
