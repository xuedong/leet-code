class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        val pq: PriorityQueue<Int> = PriorityQueue()

        for (interval in intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll()
            }
            pq.offer(interval[1])
        }

        return pq.size
    }
}
