class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heightsMap = new ArrayList<>();
        for (int[] building : buildings) {
            heightsMap.add(new int[]{building[0], -building[2]});
            heightsMap.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heightsMap, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        for (int[] height : heightsMap) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }

            int cur = pq.peek();
            if (cur != prev) {
                res.add(Arrays.asList(height[0], cur));
                prev = cur;
            }
        }

        return res;
    }
}
