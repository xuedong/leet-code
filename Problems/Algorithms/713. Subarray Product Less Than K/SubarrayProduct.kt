class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k == 0) return 0
        
        val n = nums.size
        
        var prod = 1
        var j = 0
        var ans = 0
        for (i in 0..n-1) {
            prod *= nums[i]
            if (prod < k) {
                ans += i - j + 1
            } else {
                while (prod >= k && j <= i) {
                    prod /= nums[j]
                    j++
                }
                ans += i - j + 1
            }
        }
        
        return ans
    }
}

