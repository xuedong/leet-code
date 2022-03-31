class Solution { 
    fun splitArray(nums: IntArray, m: Int): Int {
        var sum = 0
        var max = Int.MIN_VALUE
        for (num in nums) {
            sum += num
            max = maxOf(max, num)
        }
        
        var left = max
        var right = sum
        var minMaxSum = 0
        while (left <= right) {
            var mid = (left + right) / 2
            
            if (minSubarraysRequired(nums, mid) <= m) {
                right = mid - 1
                minMaxSum = mid
            } else {
                left = mid + 1
            }
        }
        
        return minMaxSum
    }
    
    private fun minSubarraysRequired(nums: IntArray, sum: Int): Int {
        var curr = 0
        var splits = 0
        
        for (num in nums) {
            if (curr + num <= sum) {
                curr += num
            } else {
                curr = num
                splits++
            }
        }
        
        return splits+1
    }
}

