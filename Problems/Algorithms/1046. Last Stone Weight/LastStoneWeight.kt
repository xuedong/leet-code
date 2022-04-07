class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int> {
            a, b -> b - a
        }
        stones.forEach { it -> heap.add(it) }
        
        while (heap.size > 1) {
            val first = heap.poll()
            val second = heap.poll()
            if (first > second) {
                heap.offer(first-second)
            }
        }
        
        if (heap.size == 1) {
            return heap.poll()
        }
        return 0
    }
}

