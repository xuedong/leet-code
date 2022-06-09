class Solution {
    fun arraySign(nums: IntArray): Int {
        var count = 0
        for (num in nums) {
            if (num == 0) return 0
            
            if (num < 0) count++
        }
        
        if (count % 2 == 0) return 1
        return -1
    }
}

