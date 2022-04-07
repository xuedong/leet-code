class Solution {
    fun reverseWords(s: String): String {
        var sb = StringBuilder()
        
        var idx = 0
        val n = s.length
        while (idx < n) {
            if (s[idx] == ' ') {
                sb.append(' ')
                idx++
            }
            
            var curr = StringBuilder()
            while (idx < s.length && s[idx] != ' ') {
                curr.append(s[idx])
                idx++
            }
            sb.append(curr.reverse())
        }
        
        return sb.toString()
    }
}

