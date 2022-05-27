class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        
        var r = n - 1
        var c = 0
        var ans = 0
        while (r >= 0 && c < m) {
            if (grid[r][c] < 0) {
                r--
                ans += m - c
            } else {
                c++
            }
        }
        
        return ans
    }
}

