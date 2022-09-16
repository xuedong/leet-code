class Solution {
    private lateinit var memo: MutableMap<Int, MutableMap<Int, Int>>

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val n = nums.size
        val m = multipliers.size
        memo = mutableMapOf()

        return dfs(nums, multipliers, 0, 0)
    }

    private fun dfs(nums: IntArray, multipliers: IntArray, i: Int, j: Int): Int {
        if (j == multipliers.size) return 0
        if (memo[i]?.get(j) != null) return memo[i]!![j]!!

        val n = nums.size
        val m = multipliers.size
        val left = nums[i] * multipliers[j] + dfs(nums, multipliers, i+1, j+1)
        val right = nums[n-1-(j-i)] * multipliers[j] + dfs(nums, multipliers, i, j+1)
        memo[i] = memo.getOrDefault(i, mutableMapOf())
        memo[i]!![j] = maxOf(left, right)
        return memo[i]!![j]!!
    }
}
