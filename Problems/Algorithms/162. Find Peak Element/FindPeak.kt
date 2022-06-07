class Solution {
    fun findPeakElement(nums: IntArray): Int {
        return search(nums, 0, nums.size-1)
    }
    
    private fun search(nums: IntArray, left: Int, right: Int): Int {
        if (left == right) return left
        
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[mid+1]) {
            return search(nums, left, mid)
        }
        return search(nums, mid+1, right)
    }
}

