class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        
        var len = -1
        var curr = 0
        var j = 0
        for (i in 0..nums.size-1) {
            curr += nums[i]
            while (j <= i && curr > sum - x) {
                curr -= nums[j]
                j++
            }
            
            if (curr == sum - x) {
                len = maxOf(len, i-j+1)
            }
        }
        
        if (len == -1) return -1
        return nums.size - len
    }
}

