class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        var col = matrix[0].size-1
        
        while (row < matrix.size && col >= 0) {
            if (matrix[row][col] == target) {
                return true
            } else if (matrix[row][col] < target) {
                row++
            } else {
                col--
            }
        }
        
        return false
    }
}

