class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        val n = nums.size
        if (n == 1) return
        
        var i = n - 2
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--
        }
        
        if (i >= 0) {
            var j = n - 1
            while (nums[j] <= nums[i]) {
                j--
            }
            
            swap(nums, i, j)
        }
        
        reverse(nums, i+1)
    }
    
    private fun swap(nums: IntArray, i: Int, j: Int): Unit {
        var temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp
    }
    
    private fun reverse(nums: IntArray, start: Int) {
        var i = start
        var j = nums.size - 1
        
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
}

