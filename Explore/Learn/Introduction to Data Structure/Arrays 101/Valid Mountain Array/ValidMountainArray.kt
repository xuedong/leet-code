class Solution {
    fun validMountainArray(A: IntArray): Boolean {
        val length = A.size
        if (length <= 2) return false
        
        var i = 0
        var up = true
        var j = length - 1
        var down = true
        while ((up || down) && i < j) {
            if (A[i+1] > A[i]) {
                i++
            } else {
                up = false
            }
            if (A[j-1] > A[j]) {
                j--
            } else {
                down = false
            }
        }
        if (i == 0 || i == length - 1 || i != j) return false
        
        return true
    }
}

