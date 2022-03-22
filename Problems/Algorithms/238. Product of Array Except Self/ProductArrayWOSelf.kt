class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n) { 1 }
        
        for (i in 1..n-1) {
            ans[i] = ans[i-1] * nums[i-1]
        }
        
        var suffix = 1
        for (i in n-1 downTo 0) {
            ans[i] = ans[i] * suffix
            suffix *= nums[i]
        }
        
        return ans
    }
}

