class NumMatrix(matrix: Array<IntArray>) {
    
    private val prefixes: Array<IntArray>
    private val n = matrix.size
    private val m = matrix[0].size
    
    init {
        prefixes = Array(n+1) { IntArray(m+1) { 0 } }
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                prefixes[i+1][j+1] = prefixes[i+1][j] + prefixes[i][j+1] - prefixes[i][j] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return prefixes[row2+1][col2+1] - prefixes[row2+1][col1] - prefixes[row1][col2+1] + prefixes[row1][col1]
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
