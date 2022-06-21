class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if (n == 1) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int sum = 0;
        int len = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i-1]) {
                if (len < ladders) {
                    pq.offer(heights[i] - heights[i-1]);
                    len++;
                } else {
                    pq.offer(heights[i] - heights[i-1]);
                    int curr = pq.poll();
                    sum += curr;
                    if (sum > bricks) {
                        return i-1;
                    }
                }
            }
        }
        
        return n-1;
    }
}

