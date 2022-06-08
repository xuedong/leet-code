class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sort()
        
        val n = nums.size
        for (i in n-1 downTo 2) {
            if (nums[i-2] + nums[i-1] > nums[i]) return nums[i-2] + nums[i-1] + nums[i]
        }
        return 0
    }
}

