class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n+1) { 0 }
        dp[1] = nums[0]
        
        for (i in 2..n) {
            dp[i] = maxOf(dp[i-1], nums[i-1]+dp[i-2])
        }
        
        return dp[n]
    }
}

