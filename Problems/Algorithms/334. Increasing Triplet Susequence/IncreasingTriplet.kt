class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        val n = nums.size
        if (n <= 2) return false
        
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (num in nums) {
            if (num <= first) {
                first = num
            } else if (num > first && num <= second) {
                second = num
            } else {
                return true
            }
        }
        
        return false
    }
}

