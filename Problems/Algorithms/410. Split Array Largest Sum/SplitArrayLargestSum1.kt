class Solution {
    private val results = Array(1001) { IntArray(51) }
    
    fun splitArray(nums: IntArray, m: Int): Int {
        val n = nums.size
        val prefix = IntArray(n+1)
        
        for (i in 0..n-1) {
            prefix[i+1] = prefix[i] + nums[i]
        }
        
        return getMinMax(prefix, 0, m)
    }
    
    private fun getMinMax(prefix: IntArray, idx: Int, count: Int): Int {
        val n = prefix.size - 1
        
        if (results[idx][count] != 0) {
            return results[idx][count]
        }
        
        if (count == 1) {
            results[idx][count] = prefix[n] - prefix[idx]
            return results[idx][count]
        }
        
        var minMaxSum = Int.MAX_VALUE
        for (i in idx..n-count) {
            val firstSum = prefix[i+1] - prefix[idx]
            val maxSum = maxOf(firstSum, getMinMax(prefix, i+1, count-1))
            minMaxSum = minOf(minMaxSum, maxSum)
            
            if (firstSum >= minMaxSum) break
        }
        
        results[idx][count] = minMaxSum
        return results[idx][count]
    }
}

