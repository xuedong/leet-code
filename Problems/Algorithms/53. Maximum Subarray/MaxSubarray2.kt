class Solution {
    fun maxSubArray(nums: IntArray): Int {
        return maxSum(nums, 0, nums.size-1)
    }
    
    private fun maxSum(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) return nums[start]
        
        val middle: Int = (start + end) / 2
        
        val leftMax: Int = maxSum(nums, start, middle)
        val rightMax: Int = maxSum(nums, middle+1, end)
        val crossMax: Int = maxCrossSum(nums, start, middle, end)
        
        return maxOf(leftMax, rightMax, crossMax)
    }
    
    private fun maxCrossSum(nums: IntArray, start: Int, middle: Int, end: Int): Int {
        var leftSum = 0
        var leftMax = Int.MIN_VALUE
        for (i in middle downTo start) {
            leftSum += nums[i]
            leftMax = maxOf(leftSum, leftMax)
        }
        
        var rightSum = 0
        var rightMax = Int.MIN_VALUE
        for (i in middle+1..end) {
            rightSum += nums[i]
            rightMax = maxOf(rightSum, rightMax)
        }
        
        return leftMax + rightMax
    }
}

