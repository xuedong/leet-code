class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sticks.length;
        for (int i = 0; i < n; i++) {
            pq.offer(sticks[i]);
        }

        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            ans += a + b;
            pq.offer(a + b);
        }

        return ans;
    }
}
