class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int curr = queue.poll();
                if (curr == n - 1) return step;

                List<Integer> neighbors = graph.get(arr[curr]);
                neighbors.add(curr - 1); neighbors.add(curr + 1);
                for (int next : neighbors) {
                    if (next >= 0 && next < n && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
                neighbors.clear();
            }
            step++;
        }

        return 0;
    }
}
