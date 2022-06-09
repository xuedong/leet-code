class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val n = arr.size
        if (n == 2) return true
        
        arr.sort()
        
        for (i in 2..arr.size-1) {
            if (arr[i] - arr[i-1] != arr[i-1] - arr[i-2]) return false
        }
        return true
    }
}

