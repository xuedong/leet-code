class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val visited = Array(n) { IntArray(m) { 0 } }
        
        var ans = 0
        for (r in 0..n-1) {
            for (c in 0..m-1) {
                val curr = dfs(grid, visited, n, m, r, c)
                if (curr > 0) {
                    ans++
                } 
            }
        }
        
        return ans
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
    
    private fun isCorner(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r == 0 || c == 0 || r == n-1 || c == m-1
    }
    
    private fun dfs(grid: Array<IntArray>, visited: Array<IntArray>, n: Int, m: Int, r: Int, c: Int): Int {
        if (!isValid(n, m, r, c) || visited[r][c] == 1 || grid[r][c] == 1) return 0
        if (isCorner(n, m, r, c)) return -1000
        
        visited[r][c] = 1
        return 1 + dfs(grid, visited, n, m, r+1, c) + dfs(grid, visited, n, m, r-1, c) + dfs(grid, visited, n, m, r, c+1) + dfs(grid, visited, n, m, r, c-1)
    }
}

