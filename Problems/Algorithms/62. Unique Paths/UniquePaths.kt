class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp: Array<IntArray> = Array(n) { IntArray(m) { 0 } }
        dp[0][0] = 1
        
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                dp[i][j] += if (i > 0) dp[i-1][j] else 0
                dp[i][j] += if (j > 0) dp[i][j-1] else 0
            }
        }
        
        return dp[n-1][m-1]
    }
}

