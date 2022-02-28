class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        val dp: IntArray = IntArray(n)
        
        dp[0] = nums[0]
        for (i in 1..n-1) {
            dp[i] = maxOf(nums[i], dp[i-1]+nums[i])
        }
        
        return dp.toList().max() ?: 0
    }
}

