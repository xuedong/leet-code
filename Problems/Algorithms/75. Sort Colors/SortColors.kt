class Solution {
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var right = nums.size-1
        var i = 0
        
        while (i <= right && left < right) {
            if (nums[i] == 0) {
                var temp = nums[i]
                nums[i] = nums[left]
                nums[left] = temp
                i++
                left++
            } else if (nums[i] == 2) {
                var temp = nums[i]
                nums[i] = nums[right]
                nums[right] = temp
                right--
            } else {
                i++
            }
        }
    }
}

