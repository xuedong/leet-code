class Solution {
    fun maximumTop(nums: IntArray, k: Int): Int {
        val n = nums.size
        
        if (n == 1) {
            if (k % 2 == 1) return -1
            else return nums[0]
        }
        
        if (n == k) {
            var best = -1
            for (i in 0..k-2) {
                if (nums[i] > best) best = nums[i]
            }
            return best
        }
        
        if (n > k) {
            var best = -1
            for (i in 0..k-2) {
                if (nums[i] > best) best = nums[i]
            }
            return maxOf(best, nums[k])
        }
        
        var best = -1
        for (i in 0..n-1) {
            if (nums[i] > best) best = nums[i]
        }
        return best
    }
}

