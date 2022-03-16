class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        var i = 0
        var j = 0
        var row = n
        var col = n
        
        val result = Array(n) { IntArray(n) }
        
        var num = 1
        while (i < row && j < col) {
            for (l in j..col-1) {
                result[i][l] = num++
            }
            i++

            for (k in i..row-1) {
                result[k][col-1] = num++
            }
            col--
            
            if (i < row) {
                for (l in col-1 downTo j) {
                    result[row-1][l] = num++
                }
                row--
            }

            if (j < col) {
                for (k in row-1 downTo i) {
                    result[k][j] = num++
                }
                j++
            }
        }
        
        return result
    }
}

