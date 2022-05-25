class Solution {
    fun arrangeCoins(n: Int): Int {
        var left = 0.toLong()
        var right = n.toLong()
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (mid * (mid + 1) / 2 <= n.toLong()) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return right.toInt()
    }
}

