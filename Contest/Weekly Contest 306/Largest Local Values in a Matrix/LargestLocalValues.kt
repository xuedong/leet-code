class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val results = Array(n-2) { IntArray(n-2) { 0 } }
        
        for (i in 1..n-2) {
            for (j in 1..n-2) {
                val curr = findMax(grid, i, j)
                results[i-1][j-1] = curr
            }
        }
        
        return results
    }
    
    private fun findMax(grid: Array<IntArray>, x: Int, y: Int): Int {
        var ans = 0
        for (i in -1..1) {
            for (j in -1..1) {
                ans = maxOf(ans, grid[x+i][y+j])
            }
        }
        return ans
    }
}

