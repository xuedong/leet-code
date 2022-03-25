class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        
        val s = x.toString()
        val n = s.length
        for (i in 0..n/2) {
            if (s[i] != s[n-1-i]) return false
        }
        
        return true
    }
}

