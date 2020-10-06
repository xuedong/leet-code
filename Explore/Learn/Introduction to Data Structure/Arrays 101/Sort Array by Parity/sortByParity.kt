class Solution {
    fun sortArrayByParity(A: IntArray): IntArray {
        val length = A.size
        var left = 0
        var right = length - 1
        
        while (left < right) {
            if (A[left] % 2 == 0 && A[right] % 2 == 1) {
                left++
                right--
            } else if (A[left] % 2 == 0 && A[right] % 2 == 0) {
                left++
            } else if (A[left] % 2 == 1 && A[right] % 2 == 1) {
                right--
            } else {
                var temp = A[left]
                A[left] = A[right]
                A[right] = temp
            }
        }
        
        return A
    }
}

