class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val n = nums.size
        
        var partial = 0; var ans = 0
        for (i in 2..n-1) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                partial++
                ans += partial
            } else {
                partial = 0
            }
        }
        
        return ans
    }
}

