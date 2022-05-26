class Solution {
    fun specialArray(nums: IntArray): Int {
        nums.sortDescending()
        val n = nums.size
        
        var left = 0
        var right = n
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > mid) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        
        return if (left < n && nums[left] == left) return -1 else left
    }
}

