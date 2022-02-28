class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        
        val len = nums.size
        for (i in 1..len-1) {
            if (nums[i] == nums[i-1]) {
                return true
            }
        }
        
        return false
    }
}

