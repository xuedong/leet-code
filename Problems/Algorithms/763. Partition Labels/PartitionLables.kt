class Solution {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26) { 0 }
        for (i in 0..s.length-1) {
            last[s.get(i)-'a'] = i 
        }
        
        var j = 0
        var anchor = 0
        
        val ans = mutableListOf<Int>()
        for (i in 0..s.length-1) {
            j = maxOf(j, last[s.get(i)-'a'])
            if (i == j) {
                ans.add(j-anchor+1)
                anchor = i + 1
            }
        }
        
        return ans
    }
}

