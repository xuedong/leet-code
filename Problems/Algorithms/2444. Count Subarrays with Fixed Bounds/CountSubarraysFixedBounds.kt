class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var ans: Long = 0
        var minPos: Int = -1
        var maxPos: Int = -1
        var left: Int = -1

        for (i in 0..nums.size-1) {
            if (nums[i] < minK || nums[i] > maxK) {
                left = i
            }

            if (nums[i] == minK) minPos = i
            if (nums[i] == maxK) maxPos = i

            ans += maxOf(0, minOf(maxPos, minPos) - left)
        }

        return ans
    }
}
