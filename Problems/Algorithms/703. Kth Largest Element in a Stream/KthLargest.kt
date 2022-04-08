class KthLargest(k: Int, nums: IntArray) {
    
    private val k: Int
    private val heap: PriorityQueue<Int>
    init {
        this.k = k
        heap = PriorityQueue<Int>()
        
        for (num in nums) {
            heap.offer(num)
        }
        
        while (heap.size > k) {
            heap.poll()
        }
    }

    fun add(`val`: Int): Int {
        heap.offer(`val`)
        
        if (heap.size > k) {
            heap.poll()
        }
        
        return heap.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
