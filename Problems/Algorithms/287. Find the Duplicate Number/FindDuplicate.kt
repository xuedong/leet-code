class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var duplicate = 0
        val n = nums.size
        val maxNum = findMax(nums)
        val maxBit = computeMaxBit(maxNum)
        
        for (bit in 0..maxBit-1) {
            val mask = 1 shl bit
            var baseCount = 0
            var numsCount = 0
            
            for (i in 0..n-1) {
                if (i and mask > 0) {
                    baseCount++
                }
                
                if (nums[i] and mask > 0) {
                    numsCount++
                }
            }
            
            if (numsCount > baseCount) {
                duplicate = duplicate or mask
            }
        }
        
        return duplicate
    }
    
    private fun findMax(nums: IntArray): Int {
        var max = 0
        for (i in 0..nums.size-1) {
            max = maxOf(max, nums[i])
        }
        return max
    }
    
    private fun computeMaxBit(num: Int): Int {
        var bits = 0
        var curr = num
        while (curr > 0) {
            bits++
            curr /= 2
        }
        return bits
    }
}

