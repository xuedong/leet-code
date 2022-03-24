class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        var ans = mutableListOf<String>()
        val n = s.length
        if (n < 10) return ans
        
        val map = mutableMapOf<String, Int>()
        
        var sb = StringBuilder(s.subSequence(0, 10))
        map.put(sb.toString(), 1)
        for (i in 10..s.length-1) {
            sb.deleteCharAt(0)
            sb.append(s[i])
            val curr = sb.toString()
            map.put(curr, map.getOrDefault(curr, 0) + 1)
        }
        
        for (str in map.keys) {
            if (map[str]!! > 1) {
                ans.add(str)
            }
        }
        
        return ans
    }
}

