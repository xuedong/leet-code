class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        if (n == 0) return -1
        
        var start = 0
        var end = n - 1
        while (start <= end) {
            var mid = start + (end - start) / 2
            
            if (nums[mid] == target) {
                return mid
            }
            
            val pivotFlag = existsInFirst(nums, start, nums[mid])
            val targetFlag = existsInFirst(nums, start, target)
            if (pivotFlag xor targetFlag) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotFlag) {
                    start = mid + 1 // pivot in the first, target in the second
                } else {
                    end = mid - 1 // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }
        return -1
    }

    private fun existsInFirst(arr: IntArray, start: Int, target: Int): Boolean {
        return arr[start] <= target
    }
}

