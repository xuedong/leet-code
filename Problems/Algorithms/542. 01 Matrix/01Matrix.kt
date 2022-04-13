class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size
        
        val dist = Array(n) { IntArray(m) { 1000000 } }
        
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0
                } else {
                    if (i > 0) {
                        dist[i][j] = minOf(dist[i][j], dist[i-1][j]+1)
                    }
                    if (j > 0) {
                        dist[i][j] = minOf(dist[i][j], dist[i][j-1]+1)
                    }
                }
            }
        }
        
        for (i in n-1 downTo 0) {
            for (j in m-1 downTo 0) {
                if (i < n-1) {
                    dist[i][j] = minOf(dist[i][j], dist[i+1][j]+1)
                }
                if (j < m-1) {
                    dist[i][j] = minOf(dist[i][j], dist[i][j+1]+1)
                }
            }
        }
        
        return dist
    }
}

