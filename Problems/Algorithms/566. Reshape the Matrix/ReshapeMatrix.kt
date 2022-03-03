class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val n = mat.size; val m = mat[0].size
        if (n * m != r * c) return mat
        
        val ans = Array(r) { IntArray(c) }
        var col = 0; var row = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                ans[row][col] = mat[i][j]
                col++
                if (col == c) {
                    col = 0
                    row++
                }
            }
        }
        
        return ans
    }
}

