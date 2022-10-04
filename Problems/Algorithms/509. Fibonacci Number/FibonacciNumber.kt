class Solution {
    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        val dp: IntArray = IntArray(n+1)
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}
