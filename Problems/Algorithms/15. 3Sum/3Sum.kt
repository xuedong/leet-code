class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var n = nums.size
        if (n <= 2) return mutableListOf()
        
        nums.sort()
        
        val results = mutableListOf<List<Int>>()
        for (i in 0..n-2) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue
            }
            
            var j = i + 1
            var k = n - 1
            while (j < k) {
                var sum = nums[i] + nums[j] + nums[k]
                if (sum == 0) {
                    results.add(listOf(nums[i], nums[j], nums[k]))
                    
                    k--
                    while (j < k && nums[k] == nums[k+1]) {
                        k--
                    }
                } else if (sum > 0) {
                    k--
                } else {
                    j++
                }
            }
        }
        
        return results
    }
}

