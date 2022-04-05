class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        
        val shift = k % n
        
        reverse(nums, n-shift, n-1)
        reverse(nums, 0, n-1)
        reverse(nums, shift, n-1)
    }
    
    private fun reverse(nums: IntArray, start: Int, end: Int): Unit {
        var i = start
        var j = end
        while (i < j) {
            nums[i] = nums[j].also { nums[j] = nums[i] }
            i++
            j--
        }
    }
}

