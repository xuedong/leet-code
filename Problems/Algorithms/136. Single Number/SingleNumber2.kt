class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        
        for (i in 0..nums.size-1){
            result = (result xor nums[i])
        }
        
        return result
    }
}

