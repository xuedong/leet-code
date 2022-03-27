class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n <= 1) return n
        
        val map = mutableMapOf<Char, Int>()
        
        var i = 0
        var j = 0
        map[s.get(0)] = 1
        var ans = 0
        while (j < n-1) {
            if (!map.containsKey(s.get(j+1)) || map[s.get(j+1)] == 0) {
                map[s.get(j+1)] = 1
                j++
            } else {
                map.put(s.get(i), map[s.get(i)]!!-1)
                i++
            }
            ans = maxOf(ans, j-i+1)
        }
        
        return ans
    }
}

