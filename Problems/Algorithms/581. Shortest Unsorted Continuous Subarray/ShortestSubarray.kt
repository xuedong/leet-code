class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val newNums = nums.copyOf()
        newNums.sort()
        
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            if (nums[i] != newNums[i] && nums[j] != newNums[j]) {
                return j-i+1
            }
            
            if (nums[i] == newNums[i]) {
                i++
            }
            
            if (nums[j] == newNums[j]) {
                j--
            }
        }
        
        return 0
    }
}

