class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        if (n == 0) return 0
        
        val left = IntArray(n) { height[0] }
        for (i in 1..n-1) {
            left[i] = maxOf(left[i-1], height[i])
        }
        
        val right = IntArray(n) { height[n-1] }
        for (i in n-2 downTo 0) {
            right[i] = maxOf(right[i+1], height[i])
        }
        
        var ans = 0
        for (i in 1..n-2) {
            ans += minOf(left[i], right[i]) - height[i]
        }
        
        return ans
    }
}

