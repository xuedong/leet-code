class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        if (isPerfectSquare(c)) return true
        
        var a = 1
        while (a * a <= c / 2) {
            val num = c - a * a
            if (isPerfectSquare(num)) {
                return true
            }
            
            a++
        }
        
        return false
    }
    
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        
        var left = 0.toLong()
        var right = num.toLong()
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            val curr = mid * mid
            if (curr == num.toLong()) {
                return true
            } else if (curr < num.toLong()) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return false
    }
}

