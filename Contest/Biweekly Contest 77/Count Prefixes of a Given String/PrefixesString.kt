class Solution {
    fun countPrefixes(words: Array<String>, s: String): Int {
        val prefixes: MutableList<String> = mutableListOf()
        
        val sb = StringBuilder()
        for (char in s) {
            sb.append(char)
            prefixes.add(sb.toString())
        }
        
        var ans = 0
        for (word in words) {
            if (prefixes.contains(word)) {
                ans++
            }
        }
        
        return ans
    }
}

