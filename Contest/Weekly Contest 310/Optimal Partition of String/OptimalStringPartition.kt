class Solution {
    fun partitionString(s: String): Int {
        var ans = 0
        
        val last = IntArray(26) { -1 }
        var start = 0
        for (i in 0..s.lastIndex) {
            if (last[s[i] - 'a'] >= start) {
                ans++
                start = i
            }
            last[s[i] - 'a'] = i
        }
        
        return ans + 1
    }
}
