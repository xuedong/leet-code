class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = matrix[0].size
        
        var row = 0
        for (i in 0..n-1) {
            if (target >= matrix[i][0])
                row = i
        }
        
        for (j in 0..m-1){
            if (matrix[row][j] == target) return true
        }
        
        return false
    }
}

