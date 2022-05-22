class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        if (n == 1) return 1
        
        var ans = 0
        for (i in 0..n-2) {
            ans++
            
            var left = i - 1
            var right = i + 1
            while (left >= 0 && right <= n-1 && s.get(left) == s.get(right)) {
                ans++
                left--
                right++
            }
            
            left = i
            right = i + 1
            while (left >= 0 && right <= n-1 && s.get(left) == s.get(right)) {
                ans++
                left--
                right++
            }
        }
        ans++
        
        return ans
    }
}

