class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return Regex(p).matches(s)
    }
}

