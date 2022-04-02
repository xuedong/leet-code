class Solution {
    fun triangularSum(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]
   
        val temp = IntArray(n-1)
        for (i in 0..n-2) {
            val curr = (nums[i] + nums[i + 1]) % 10
            temp[i] = curr
        }
   
        return triangularSum(temp)
    }
}

