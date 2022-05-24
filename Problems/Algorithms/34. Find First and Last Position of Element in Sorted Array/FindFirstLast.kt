class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left1 = 0
        var right1 = nums.size - 1
        
        var ans1 = -1
        while (left1 <= right1) {
            val mid = left1 + (right1 - left1) / 2
            
            if (nums[mid] == target) {
                ans1 = mid
                right1 = mid - 1
            } else if (nums[mid] > target) {
                right1 = mid - 1
            } else {
                left1 = mid + 1
            }
        }
        
        var left2 = 0
        var right2 = nums.size - 1
        
        var ans2 = -1
        while (left2 <= right2) {
            val mid = left2 + (right2 - left2) / 2
            
            if (nums[mid] == target) {
                ans2 = mid
                left2 = mid + 1
            } else if (nums[mid] > target) {
                right2 = mid - 1
            } else {
                left2 = mid + 1
            }
        }
        
        return intArrayOf(ans1, ans2)
    }
}

