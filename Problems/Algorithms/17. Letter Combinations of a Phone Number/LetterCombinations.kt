class Solution {
    private val combinations: MutableList<String>
    
    init {
        combinations = mutableListOf()
    }
    
    fun letterCombinations(digits: String): List<String> {
        if (digits.length <= 0) return combinations
        
        val map: Array<String> = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val sb = StringBuilder()
        aux(digits, sb, map, 0)
        
        return combinations
    }
    
    private fun aux(digits: String, sb: StringBuilder, map: Array<String>, idx: Int) {
        if (idx == digits.length) {
            combinations.add(sb.toString())
            return
        }
        
        val num = digits.get(idx) - '0'
        val letters = map[num]
        for (letter in letters) {
            sb.append(letter)
            aux(digits, sb, map, idx+1)
            sb.deleteCharAt(sb.length-1)
        }
    }
}

