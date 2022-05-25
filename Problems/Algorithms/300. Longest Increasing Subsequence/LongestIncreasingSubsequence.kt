class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n+1) { Int.MAX_VALUE }
        dp[n-1] = 1
        
        for (i in n-2 downTo 0) {
            var curr = 0
            for (j in i+1..n-1) {
                if (nums[j] > nums[i]) {
                    curr = maxOf(curr, dp[j])
                }
            }
            dp[i] = curr + 1
        }
        
        var ans = 0
        for (i in 0..n-1) {
            ans = maxOf(ans, dp[i])
        }
        return ans
    }
}

