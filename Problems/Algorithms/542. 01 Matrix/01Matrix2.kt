class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size
        
        val queue = ArrayDeque<IntArray>()
        val results: Array<IntArray> = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (mat[i][j] == 0) {
                    results[i][j] = 0
                    queue.add(intArrayOf(i, j))
                }
            }
        }
        
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            val r = curr[0]
            val c = curr[1]
            
            for (neighbor in neighbors) {
                val x = r + neighbor[0]
                val y = c + neighbor[1]
                
                if (isValid(n, m, x, y)) {
                    if (results[x][y] > results[r][c] + 1) {
                        results[x][y] = results[r][c] + 1
                        queue.add(intArrayOf(x, y))
                    }
                }
            }
        }
        
        return results;
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

