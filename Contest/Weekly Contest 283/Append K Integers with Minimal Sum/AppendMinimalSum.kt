class Solution {
    fun minimalKSum(nums: IntArray, k: Int): Long {
        nums.sort()
        val len = nums.size
        
        var ans = 0.toLong(); var kk = k.toLong()
        for (i in 0..len-1) {
            if (i == 0) {
                val curr: Long = minOf(kk, (nums[i]-1).toLong())
                ans += curr * (curr+1) / 2
                kk -= nums[i] - 1
                if (kk <= 0) return ans
            } else if (nums[i] - nums[i-1] <= 1) {
                continue
            } else {
                val curr: Long = minOf(kk, (nums[i]-nums[i-1]-1).toLong())
                ans += nums[i-1] * curr + curr * (curr+1) / 2
                kk -= nums[i] - nums[i-1] - 1
                if (kk <= 0) return ans
            }
        }
        ans += nums[len-1] * kk + kk * (kk+1) / 2
        
        return ans
    }
}

