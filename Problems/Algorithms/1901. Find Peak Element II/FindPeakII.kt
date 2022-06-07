class Solution {
    fun findPeakGrid(mat: Array<IntArray>): IntArray {
        val n = mat.size
        val m = mat[0].size
        
        var top = 0
        var bottom = n - 1
        while (top <= bottom) {
            val mid = top + (bottom - top) / 2
            val maxCol = findMax(mat[mid])
            
            if ((mid == 0 || mat[mid][maxCol] > mat[mid-1][maxCol]) && (mid == n - 1 || mat[mid][maxCol] > mat[mid+1][maxCol])) {
                return intArrayOf(mid, maxCol)
            }
            
            if (mid > 0 && mat[mid][maxCol] < mat[mid-1][maxCol]) {
                bottom = mid - 1
            } else {
                top = mid + 1
            }
        }
        
        return intArrayOf(-1, -1)
    }
    
    private fun findMax(arr: IntArray): Int {
        var id = 0
        var max = 0
        for (i in 0..arr.size-1) {
            if (max < arr[i]) {
                max = arr[i]
                id = i
            }
        }
        return id
    }
}

