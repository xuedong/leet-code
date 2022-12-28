class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < piles.length; i++) {
            pq.offer(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            pq.offer(curr - curr / 2);
        }

        int ans = 0;
        for (int num : pq) {
            ans += num;
        }

        return ans;
    }
}
