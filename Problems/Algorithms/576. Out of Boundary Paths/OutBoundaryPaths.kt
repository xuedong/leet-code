class Solution {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val MOD = 1000000007
        
        val dp: Array<IntArray> = Array(m) { IntArray(n) { 0 } }
        dp[startRow][startColumn] = 1
        
        var ans = 0
        for (move in 1..maxMove) {
            val curr: Array<IntArray> = Array(m) { IntArray(n) { 0 } }
            for (i in 0..m-1) {
                for (j in 0..n-1) {
                    if (i == m - 1) ans = (ans + dp[i][j]) % MOD
                    if (j == n - 1) ans = (ans + dp[i][j]) % MOD
                    if (i == 0) ans = (ans + dp[i][j]) % MOD
                    if (j == 0) ans = (ans + dp[i][j]) % MOD
                    
                    curr[i][j] = (((if (i > 0) dp[i-1][j] else 0) + (if (i < m-1) dp[i+1][j] else 0)) % MOD + ((if (j > 0) dp[i][j-1] else 0) + (if (j < n-1) dp[i][j+1] else 0)) % MOD) % MOD
                }
            }
            
            for (i in 0..m-1) {
                for (j in 0..n-1) {
                    dp[i][j] = curr[i][j]
                }
            }
        }
        
        return ans
    }
}

