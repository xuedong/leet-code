class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        var ans = n+1
        
        var sum = 0
        var j = 0
        for (i in 0..n-1) {
            sum += nums[i]
            if (sum >= target) {
                while (sum >= target && j <= i) {
                    sum -= nums[j]
                    j++
                }
                ans = minOf(ans, i-j+1)
            }
        }
        
        if (ans == n+1) return 0
        return ans+1
    }
}

