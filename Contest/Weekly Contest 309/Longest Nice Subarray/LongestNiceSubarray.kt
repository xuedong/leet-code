class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        val n = nums.size

        var curr = 0
        var j = 0
        var ans = 0
        for (i in 0..n-1) {
            while (curr and nums[i] > 0) {
                curr = curr xor nums[j]
                j++
            }
            curr = curr or nums[i]
            ans = maxOf(ans, i-j+1)
        }

        return ans
    }
}
