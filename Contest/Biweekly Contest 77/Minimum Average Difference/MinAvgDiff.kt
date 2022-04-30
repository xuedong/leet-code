class Solution {
    fun minimumAverageDifference(nums: IntArray): Int {
        val n = nums.size
        
        var sum: Long = 0.toLong()
        val prefixes = LongArray(n) { 0 }
        for (i in 0..n-1) {
            sum += nums[i]
            prefixes[i] = sum
        }
        
        var best = Long.MAX_VALUE
        var id = 0
        for (i in 0..n-1) {
            val suffix = sum - prefixes[i]
            var absDiff = 0.toLong()
            if (i < n-1) {
                absDiff = Math.abs(prefixes[i] / (i+1) - suffix / (n-i-1))
            } else {
                absDiff = sum / n
            }
            
            if (absDiff < best) {
                best = absDiff
                id = i
            }
        }
        
        return id
    }
}

