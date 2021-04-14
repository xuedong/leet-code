class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val length = nums.size
        var i = 0
        var j = length - 1
        
        while (i <= j) {
            if (nums[i] == `val`) {
                var tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                j--
            } else {
                i++    
            }
        }
        
        return j+1
    }
}

