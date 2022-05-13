class Solution {
    private val neighbors: Array<IntArray> = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val n = heights.size
        val m = heights[0].size
        
        val reachableAtlantic: Array<BooleanArray> = Array(n) { BooleanArray(m) { false } }
        for (c in 0..m-1) {
            dfs(heights, n, m, n-1, c, reachableAtlantic)
        }
        for (r in 0..n-1) {
            dfs(heights, n, m, r, m-1, reachableAtlantic)
        }
        
        val reachablePacific: Array<BooleanArray> = Array(n) { BooleanArray(m) { false } }
        for (c in 0..m-1) {
            dfs(heights, n, m, 0, c, reachablePacific)
        }
        for (r in 0..n-1) {
            dfs(heights, n, m, r, 0, reachablePacific)
        }
        
        val results: MutableList<List<Int>> = mutableListOf()
        for (r in 0..n-1) {
            for (c in 0..m-1) {
                if (reachableAtlantic[r][c] && reachablePacific[r][c]) {
                    results.add(listOf(r, c))
                }
            }
        }
        return results
    }
    
    private fun dfs(heights: Array<IntArray>, n: Int, m: Int, r: Int, c: Int, reachable: Array<BooleanArray>): Unit {
        reachable[r][c] = true
            
        for (neighbor in neighbors) {
            val x = r + neighbor[0]
            val y = c + neighbor[1]
            if (isValid(n, m, x, y) && !reachable[x][y] && heights[x][y] >= heights[r][c]) {
                dfs(heights, n, m, x, y, reachable)
            }
        }
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

