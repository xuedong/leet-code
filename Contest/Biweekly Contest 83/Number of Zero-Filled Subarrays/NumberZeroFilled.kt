class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        val n = nums.size
        
        var i = 0
        var j = 0
        var ans = 0.toLong()
        while (j < n) {
            if (nums[j] == 0) {
                j++
            } else {
                val curr = j - i
                ans += curr.toLong() * (curr+1).toLong() / 2
                j++
                i = j
            }
        }
        val curr = j - i
        ans += curr.toLong() * (curr+1).toLong() / 2
        
        return ans
    }
}

