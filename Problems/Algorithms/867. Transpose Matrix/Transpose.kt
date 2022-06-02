class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        val m = matrix[0].size
        
        val ans = Array(m) { IntArray(n) { 0 } }
        for (j in 0..m-1) {
            for (i in 0..n-1) {
                ans[j][i] = matrix[i][j]
            }
        }
        
        return ans
    }
}

