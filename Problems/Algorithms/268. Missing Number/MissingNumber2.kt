class Solution {
    fun missingNumber(nums: IntArray): Int {
        var total = 0
        for (num in nums) {
            total += num
        }
        
        val n = nums.size
        
        return n * (n+1) / 2 - total
    }
}

