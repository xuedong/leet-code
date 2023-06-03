class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(headID, 0));
        
        int ans = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int node = curr.getKey();
            int time = curr.getValue();
            ans = Math.max(ans, time);
            
            for (int neighbor : graph.get(node)) {
                queue.offer(new Pair(neighbor, informTime[node]+time));
            }
        }
        
        return ans;
    }
}
