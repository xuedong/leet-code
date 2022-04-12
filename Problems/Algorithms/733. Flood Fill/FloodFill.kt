class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val color = image[sr][sc]
        
        val n = image.size
        val m = image[0].size
        if (color != newColor) {
            dfs(image, n, m, sr, sc, color, newColor)
        }
        
        return image
    }
    
    private fun dfs(image: Array<IntArray>, n: Int, m: Int, r: Int, c: Int, color: Int, newColor: Int): Unit {
        if (image[r][c] == color) {
            image[r][c] = newColor
            
            val neighbors: Array<IntArray> = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
            for (neighbor in neighbors) {
                val x = r + neighbor[0]
                val y = c + neighbor[1]
                if (isValid(n, m, x, y)) {
                    dfs(image, n, m, x, y, color, newColor)
                }
            }
        }
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

