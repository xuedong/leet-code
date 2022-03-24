class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""
        var length = 0
        val n = s.length
        
        for (i in 0..n-1) {
            var left = i
            var right = i
            while (left >= 0 && right < n && s[left] == s[right]) {
                if (right - left + 1 > length) {
                    result = s.subSequence(left, right+1).toString()
                    length = right - left + 1
                }
                left--
                right++
            }
            
            left = i
            right = i + 1
            while (left >= 0 && right < n && s[left] == s[right]) {
                if (right - left + 1 > length) {
                    result = s.subSequence(left, right+1).toString()
                    length = right - left + 1
                }
                left--
                right++
            }
        }
            
        return result
    }
}

