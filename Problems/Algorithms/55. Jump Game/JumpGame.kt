class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        val dp = BooleanArray(n)
        dp[n-1] = true
        
        for (i in n-2 downTo 0) {
            if (nums[i] >= n-1-i) {
                dp[i] = true
            } else {
                dp[i] = dp.copyOfRange(i+1, i+nums[i]+1).any { it }
            }
        }
        
        return dp[0]
    }
}

