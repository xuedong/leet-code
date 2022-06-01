class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val n = nums.size
        val sums = IntArray(n) { 0 }
        
        var prefix = 0
        for (i in 0..n-1) {
            prefix += nums[i]
            sums[i] = prefix
        }
        
        return sums
    }
}

