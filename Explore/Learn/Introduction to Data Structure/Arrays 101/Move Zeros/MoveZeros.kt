class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val length = nums.size
        var indexNonZeros = 0
        
        for (i in 0..(length-1)) {
            if (nums[i] != 0) {
                nums[indexNonZeros] = nums[i]
                indexNonZeros++
            }
        }
        
        for (i in indexNonZeros..(length-1)) {
            nums[i] = 0
        }
    }
}

