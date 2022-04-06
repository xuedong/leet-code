class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val n = nums.size
        if (n == 1) return
        
        var i = 0
        var j = 1
        while (j < n) {
            if (nums[i] == 0 && nums[j] == 0) {
                j++
            } else if (nums[j] == 0) {
                i++
                j++
            } else if (nums[i] == 0) {
                nums[i] = nums[j].also { nums[j] = nums[i] }
                i++
                j++
            } else {
                val temp = j
                j++
                i = temp
            }
        }
    }
}

