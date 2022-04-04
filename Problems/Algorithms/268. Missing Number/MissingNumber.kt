class Solution {
    fun missingNumber(nums: IntArray): Int {
        var ans = 0
        
        for (num in nums) {
            ans = (ans xor num)
        }
        
        for (num in 0..nums.size) {
            ans = (ans xor num)
        }
        
        return ans
    }
}

