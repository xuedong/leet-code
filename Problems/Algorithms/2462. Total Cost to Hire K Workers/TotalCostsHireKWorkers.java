class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> head = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            head.add(costs[i]);
        }
        for (int i = Math.max(candidates, n - candidates); i < n; i++) {
            tail.add(costs[i]);
        }

        long ans = 0;
        int nextHead = candidates;
        int nextTail = n - 1 - candidates;

        for (int i = 0; i < k; i++) {
            if (tail.isEmpty() || !head.isEmpty() && head.peek() <= tail.peek()) {
                ans += head.poll();

                if (nextHead <= nextTail) {
                    head.add(costs[nextHead]);
                    nextHead++;
                }
            } else {
                ans += tail.poll();

                if (nextHead <= nextTail) {
                    tail.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return ans;
    }
}
