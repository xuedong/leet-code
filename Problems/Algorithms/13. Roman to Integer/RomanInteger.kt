class Solution {
    fun romanToInt(s: String): Int {
        val values = mapOf('I' to 1,
                           'V' to 5, 
                           'X' to 10, 
                           'L' to 50,
                           'C' to 100,
                           'D' to 500,
                           'M' to 1000)
        
        var t = s.replace("IV", "IIII")
        t = t.replace("IX", "VIIII")
        t = t.replace("XL", "XXXX")
        t = t.replace("XC", "LXXXX")
        t = t.replace("CD", "CCCC")
        t = t.replace("CM", "DCCCC")
        
        var ans = 0
        for (ch in t) {
            ans += values[ch]!!
        }
        
        return ans
    }
}

