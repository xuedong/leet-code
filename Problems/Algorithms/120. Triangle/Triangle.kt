class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        for (j in 0..n-1) {
            dp[n-1][j] = triangle[n-1][j]
        }
        
        for (i in n-2 downTo 0) {
            val m = triangle[i].size
            for (j in 0..m-1) {
                dp[i][j] = triangle[i][j]
                dp[i][j] += minOf(dp[i+1][j], dp[i+1][j+1])
            }
        }
        
        return dp[0][0]
    }
}

