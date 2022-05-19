class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        val dp = Array(n) { IntArray(m) { -1 } }
        
        var ans = 0
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                ans = maxOf(ans, dfs(matrix, dp, neighbors, n, m, i, j, -1))
            }
        }
        return ans
    }
    
    private fun dfs(matrix: Array<IntArray>, dp: Array<IntArray>, neighbors: Array<IntArray>, n: Int, m: Int, r: Int, c: Int, prev: Int): Int {
        if (!isValid(n, m, r, c) || matrix[r][c] <= prev) {
            return 0
        }
        
        if (dp[r][c] != -1) {
            return dp[r][c]
        }
        
        for (neighbor in neighbors) {
            val x = r + neighbor[0]
            val y = c + neighbor[1]
            
            dp[r][c] = maxOf(dp[r][c], dfs(matrix, dp, neighbors, n, m, x, y, matrix[r][c]))
        }
        
        dp[r][c]++
        return dp[r][c]
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

