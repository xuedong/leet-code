class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        val sum: Int = nums.sum()
        var ans = nums[0]
        var minSum = 0
        var maxSum = nums[0]
        for (i in 1..nums.size-1) {
            maxSum = Math.max(maxSum+nums[i], nums[i])
            minSum = Math.min(minSum+nums[i], nums[i])
            ans = Math.max(ans, Math.max(maxSum, sum-minSum))
        }

        return ans
    }
}
