class Solution {
    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length-1
        
        while (left < right) {
            if (s[left] == s[right]) {
                left++
                right--
            } else {
                var sl = StringBuilder(s)
                var sr = StringBuilder(s)
                sl.deleteCharAt(left)
                sr.deleteCharAt(right)
                return sl.reversed().toString().equals(sl.toString()) || sr.reversed().toString().equals(sr.toString())
            }
        }
        
        return true
    }
}

