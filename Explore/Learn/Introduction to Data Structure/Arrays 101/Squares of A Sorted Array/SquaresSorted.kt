class Solution1 {
    fun sortedSquares(A: IntArray): IntArray {
        val B = IntArray(A.size)
        for (id in B.indices) {
            B[id] = A[id] * A[id]
        }
        
        return B.sortedArray()
    }
}


class Solution2 {
    fun sortedSquares(A: IntArray): IntArray {
        val N = A.size
        var B = IntArray(N)
        var j = 0
        while (j < N && A[j] < 0) {
            j++
        }
        var i = j-1
        var k = 0
        
        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                B[k++] = A[i] * A[i]
                i--
            } else {
                B[k++] = A[j] * A[j]
                j++
            }
        }
        
        while (i >= 0) {
            B[k++] = A[i] * A[i]
            i--
        }
        while (j < N) {
            B[k++] = A[j] * A[j]
            j++
        }
        
        return B
    }
}

