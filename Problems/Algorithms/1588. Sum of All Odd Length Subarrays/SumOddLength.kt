class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        val n = arr.size
        
        var ans = 0
        var freq = 0
        for (i in 0..n-1) {
            freq += (n - i + 1) / 2 - (i + 1) / 2
            ans += freq * arr[i]
        }
        
        return ans
    }
}

