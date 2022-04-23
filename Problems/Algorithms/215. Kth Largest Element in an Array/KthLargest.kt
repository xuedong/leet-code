class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sorted()[nums.size-k]
    }
}

