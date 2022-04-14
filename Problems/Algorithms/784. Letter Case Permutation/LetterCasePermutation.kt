class Solution {
    fun letterCasePermutation(s: String): List<String> {
        return aux(s, 0)
    }
    
    private fun aux(s: String, id: Int): List<String> {
        if (id == s.length) return listOf("")
        
        val substrings = aux(s, id+1)
        val curr = s[id]
        
        val candidates = if (curr.isLetter()) listOf(curr.toUpperCase(), curr.toLowerCase()) else listOf(curr)
        
        return candidates.flatMap { candidate -> substrings.map { substring -> candidate + substring } }
    }
}

