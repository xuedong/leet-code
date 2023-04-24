class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size() != 1) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            heap.offer(stone1 - stone2);
        }

        return heap.poll();
    }
}
