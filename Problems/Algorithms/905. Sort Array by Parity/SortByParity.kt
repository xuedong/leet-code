class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var i = 0
        var j = nums.size-1
        
        while (i < j) {
            while (nums[i] % 2 == 0 && i < j) {
                i++
            }
            while (nums[j] % 2 == 1 && j > i) {
                j--
            }
            
            if (i < j) {
                nums[i] = nums[j].also { nums[j] = nums[i] }
            }
        }
        
        return nums
    }
}

