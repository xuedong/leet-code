class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val results: MutableList<String> = mutableListOf()
        if (n == 0) return listOf("")
        
        for (i in 0..n-1) {
            for (left in generateParenthesis(i)) {
                for (right in generateParenthesis(n-1-i)) {
                    results.add("(" + left + ")" + right)
                }
            }
        }
        
        return results
    }
}

