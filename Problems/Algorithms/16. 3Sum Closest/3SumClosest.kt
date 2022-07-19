class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val n = nums.size
        var result = nums[0] + nums[1] + nums[n-1]
        
        nums.sort()
        for (i in 0..n-3) {
            var j = i + 1
            var k = n - 1
            while (j < k) {
                val curr = nums[i] + nums[j] + nums[k]
                if (curr > target) {
                    k--
                } else {
                    j++
                }
                
                if (Math.abs(curr - target) < Math.abs(result - target)) {
                    result = curr
                }
            }
        }
        
        return result
    }
}

