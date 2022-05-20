class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val n = obstacleGrid.size
        val m = obstacleGrid[0].size
        
        val dp: Array<IntArray> = Array(n) { IntArray(m) { 0 } }
        if (obstacleGrid[0][0] != 1) dp[0][0] = 1
        
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else {
                    dp[i][j] += if (i > 0) dp[i-1][j] else 0
                    dp[i][j] += if (j > 0) dp[i][j-1] else 0
                }
            }
        }
        
        return dp[n-1][m-1]
    }
}

