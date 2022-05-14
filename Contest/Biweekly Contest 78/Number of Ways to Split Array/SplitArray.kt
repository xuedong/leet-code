class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size
        val prefixes = LongArray(n-1) { 0 }
        
        var prefix = 0.toLong()
        for (i in 0..n-2) {
            prefix += nums[i]
            prefixes[i] = prefix
        }
        prefix += nums[n-1]
        
        var ans = 0
        for (i in 0..n-2) {
            if (prefixes[i] >= prefix - prefixes[i]) {
                ans++
            }
        }
        
        return ans
    }
}

