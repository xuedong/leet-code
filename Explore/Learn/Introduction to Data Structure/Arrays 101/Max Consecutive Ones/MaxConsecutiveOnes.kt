class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var current = 0
        
        nums.forEach {
            if (it == 0) {
                max = maxOf(current, max)
                current = 0
            } else {
                current += 1
            }
        }
        
        return maxOf(current, max)
    }
}

