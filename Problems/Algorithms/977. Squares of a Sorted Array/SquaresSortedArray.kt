class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        var res = IntArray(n)
        var j = 0
        while (j < n && nums[j] < 0) {
            j++
        }
        var i = j-1
        var k = 0
        
        while (i >= 0 && j < n) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k++] = nums[i] * nums[i]
                i--
            } else {
                res[k++] = nums[j] * nums[j]
                j++
            }
        }
        
        while (i >= 0) {
            res[k++] = nums[i] * nums[i]
            i--
        }
        while (j < n) {
            res[k++] = nums[j] * nums[j]
            j++
        }
        
        return res
    }
}

