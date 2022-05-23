class Solution {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        
        var left = 1.toLong()
        var right = x.toLong()
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (mid * mid == x.toLong()) {
                return mid.toInt()
            }
            if (mid * mid < x.toLong()) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return (left - 1).toInt()
    }
}

