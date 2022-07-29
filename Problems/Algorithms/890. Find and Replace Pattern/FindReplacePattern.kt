class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val results: MutableList<String> = mutableListOf()
        for (word in words) {
            if (match(word, pattern)) {
                results.add(word)
            }
        }
        return results
    }
    
    private fun match(word: String, pattern: String): Boolean {
        val map1: MutableMap<Char, Char> = mutableMapOf()
        val map2: MutableMap<Char, Char> = mutableMapOf()
        
        for (i in 0..word.length-1) {
            val w = word.get(i)
            val p = pattern.get(i)
            
            if (!map1.containsKey(w)) {
                map1.put(w, p)
            }
            if (!map2.containsKey(p)) {
                map2.put(p, w)
            }
            
            if (map1.get(w)!! != p || map2.get(p)!! != w) {
                return false
            }
        }
        
        return true
    }
}

