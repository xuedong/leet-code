class Solution {
    val results: MutableList<List<String>>
    val curr: MutableList<String>

    init {
        results = mutableListOf()
        curr = mutableListOf()
    }

    fun partition(s: String): List<List<String>> {
        helper(s, 0)
        return results
    }
        
    private fun helper(s: String, start: Int) {
        if (start >= s.length) {
            results.add(curr.toMutableList())
            return
        }

        for (i in start..s.length-1) {
            if (isPalindrome(s.substring(start, i+1))) {
                curr.add(s.substring(start, i+1))
                helper(s, i+1)
                curr.removeAt(curr.size-1)
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        return s == s.reversed()
    }
}
