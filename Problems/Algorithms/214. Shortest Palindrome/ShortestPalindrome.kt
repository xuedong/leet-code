class Solution {
    fun shortestPalindrome(s: String): String {
        val n = s.length
        val sRev = s.reversed()
        val sCom = s + "." + sRev
        
        val m = sCom.length
        val kmp = IntArray(m) { 0 }
        for (i in 1..m-1) {
            var t = kmp[i-1]
            while (t > 0 && sCom[i] != sCom[t]) {
                t = kmp[t-1]
            }
            if (sCom[i] == sCom[t]) {
                t++
            }
            kmp[i] = t
        }
        
        return sRev.substring(0, n-kmp[m-1]) + s
    }
}

