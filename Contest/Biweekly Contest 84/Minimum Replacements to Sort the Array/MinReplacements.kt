class Solution {
    fun minimumReplacement(nums: IntArray): Long {
        val n = nums.size
        if (n == 1) return 0
        
        var ans: Long = 0
        var i = n - 2
        var prev = nums[n-1]
        while (i >= 0) {
            val curr = nums[i]
            
            if (curr > prev) {
                if (curr % prev == 0) {
                    ans += curr / prev - 1
                } else {
                    ans += curr / prev
                    prev = (curr - (curr / prev - 1) * prev) / 2
                }
            } else {
                prev = curr
            }
            
            i--
        }
        
        return ans
    }
}

