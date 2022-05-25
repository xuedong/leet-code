class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        val n = nums.size
        
        var j = 0
        var ans = 0
        for (i in 1..n-1) {
            if (nums[i] <= nums[i-1]) {
                ans = maxOf(ans, i-j)
                j = i
            }
        }
        ans = maxOf(ans, n-j)
        
        return ans
    }
}

