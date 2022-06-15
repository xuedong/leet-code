class Solution {
    fun longestStrChain(words: Array<String>): Int {
        val n = words.size
        if (n == 1) return 1
        
        words.sortBy { it.length }
        
        val map: MutableMap<String, Int> = mutableMapOf()
        var ans = 0
        for (word in words) {
            var curr = 0
            for (i in 0..word.length-1) {
                val prev = word.substring(0, i) + word.substring(i+1)
                curr = maxOf(curr, map.getOrDefault(prev, 0)+1)
            }
            map.put(word, curr)
            ans = maxOf(ans, curr)
        }
        
        return ans
    }
}

