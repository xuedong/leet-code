class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val pile = IntArray(n) { 0 }
        
        var size = 0
        for (num in nums) {
            var left = 0
            var right = size
            
            while (left < right) {
                val mid = left + (right - left) / 2
                if (pile[mid] < num) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            
            pile[left] = num
            if (left == size) size++
        }
        
        return size
    }
}

