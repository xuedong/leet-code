class Solution(nums: IntArray) {
    
    private val nums: IntArray
    
    init {
        this.nums = nums
    }

    fun reset(): IntArray {
        return this.nums
    }

    fun shuffle(): IntArray {
        val shuffled = this.nums.clone()
        
        for (i in 0..nums.size-1) {
            val j = (i..this.nums.size-1).random()
            shuffled[i] = shuffled[j].also { shuffled[j] = shuffled[i] }
        }
        
        return shuffled
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
