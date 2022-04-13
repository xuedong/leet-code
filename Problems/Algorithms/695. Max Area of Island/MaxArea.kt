class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        
        val visited = Array(n) { IntArray(m) { 0 } }
        
        var ans = 0
        for (r in 0..n-1) {
            for (c in 0..m-1) {
                ans = maxOf(ans, dfs(grid, visited, n, m, r, c))
            }
        }
        
        return ans
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
    
    private fun dfs(grid: Array<IntArray>, visited: Array<IntArray>, n: Int, m: Int, r: Int, c: Int): Int {
        if (!isValid(n, m, r, c) || visited[r][c] == 1 || grid[r][c] == 0) return 0
        
        visited[r][c] = 1
        return 1 + dfs(grid, visited, n, m, r+1, c) + dfs(grid, visited, n, m, r-1, c) + dfs(grid, visited, n, m, r, c+1) + dfs(grid, visited, n, m, r, c-1)
    }
}

