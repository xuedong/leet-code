class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        if (n <= 1) return n
        
        var up = 0
        var down = 0
        var ans = 0
        var prev = 0
        for (i in 1..n-1) {
            var curr = 0
            if (ratings[i] > ratings[i-1]) {
                curr = 1
            } else if (ratings[i] < ratings[i-1]) {
                curr = -1
            }
            
            if ((prev > 0 && curr == 0) || (prev < 0 && curr >= 0)) {
                ans += up * (up+1) / 2 + down * (down+1) / 2 + maxOf(up, down)
                up = 0
                down = 0
            }
            
            if (curr > 0) {
                up++
            } else if (curr < 0) {
                down++
            } else {
                ans++
            }
            prev = curr
        }
        ans += up * (up+1) / 2 + down * (down+1) / 2 + maxOf(up, down) + 1
        
        return ans
    }
}

