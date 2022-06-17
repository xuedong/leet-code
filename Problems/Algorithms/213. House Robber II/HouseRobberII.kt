class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]
        if (n == 2) return maxOf(nums[0], nums[1])
        if (n == 3) return maxOf(maxOf(nums[0], nums[1]), nums[2])
        
        return maxOf(nums[0] + aux(nums.copyOfRange(2, nums.size-1)), aux(nums.copyOfRange(1, nums.size)))
    }
    
    private fun aux(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n+1) { 0 }
        dp[1] = nums[0]
        
        for (i in 2..n) {
            dp[i] = maxOf(dp[i-1], nums[i-1]+dp[i-2])
        }
        
        return dp[n]
    }
}

