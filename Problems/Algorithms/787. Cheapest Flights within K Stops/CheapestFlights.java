class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, src, 0 });
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];

            if (steps > stops[node] || steps > k + 1) {
                continue;
            }
            stops[node] = steps;

            if (node == dst) {
                return dist;
            }
            
            if (!adj.containsKey(node)) {
                continue;
            }
            
            for (int[] neighbor : adj.get(node)) {
                pq.offer(new int[] { dist + neighbor[1], neighbor[0], steps + 1 });
            }
        }
        
        return -1;
    }
}
