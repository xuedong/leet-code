class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        val n = nums.size
        
        var len = 0.toLong()
        var sum = 0.toLong()
        var ans = 0.toLong()
        var j = 0
        for (i in 0..n-1) {
            sum += nums[i].toLong()
            len++
            
            var curr = sum * len
            while (curr >= k && j <= i) {
                sum -= nums[j].toLong()
                len--
                curr = sum * len
                j++
            }
            
            ans += (i - j + 1).toLong()
        }
        
        return ans
    }
}

